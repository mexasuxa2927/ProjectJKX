package com.example.movieapp.utils.paging3

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.movieapp.data.releases.Release
import com.example.movieapp.network.ApiService

class ComingSoonPagingSource(val apiService: ApiService,month:String,year:Int) : PagingSource<Int,Release >() {

    override fun getRefreshKey(state: PagingState<Int, Release>): Int? {
        return state.anchorPosition?.let { position ->
            state.closestPageToPosition(position)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(position)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Release> {
        return try {
            val nextPage = params.key ?: 1
            val response = apiService.getComingsoon(year = 2024, month = "FEBRUARY",nextPage)

            LoadResult.Page(
                data =response.body()!!.releases,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (response.body()!!.releases.isEmpty()) null else nextPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }


}