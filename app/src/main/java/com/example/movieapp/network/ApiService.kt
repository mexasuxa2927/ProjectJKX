package com.example.movieapp.network

import com.example.movieapp.data.collectionsmovie.CollectionsMovie
import com.example.movieapp.data.moive.SingleMovieData
import com.example.movieapp.data.releases.ReleasesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    //releasesdata
    @GET("api/v2.1/films/releases")
    @Headers("X-API-KEY:781988e7-aca4-4dc0-b60f-1f4a1dcdc31a")
    suspend fun getLastReleaseMovie(@Query("year")year:Int,@Query("month")month:String):Response<ReleasesResponse>


    //films/premieres
    @GET("api/v2.2/films/collections")
    @Headers("X-API-KEY:781988e7-aca4-4dc0-b60f-1f4a1dcdc31a")
    suspend fun getCollections(@Query("type")type:String,@Query("page")page:Int):Response<CollectionsMovie>

    @GET("api/v2.2/films/{id}")
    @Headers("X-API-KEY:781988e7-aca4-4dc0-b60f-1f4a1dcdc31a")
    suspend fun getSingleFilmById(@Path("id")id:Int):Response<SingleMovieData>



}