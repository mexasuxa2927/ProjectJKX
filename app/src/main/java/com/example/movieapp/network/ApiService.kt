package com.example.movieapp.network

import com.example.movieapp.data.actor_respons.ActorByIdRespons
import com.example.movieapp.data.collectionsmovie.CollectionsMovie
import com.example.movieapp.data.moive.SingleMovieData
import com.example.movieapp.data.movie_creaters.Actors
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

    @GET("/api/v2.2/films/{id}")
    @Headers("X-API-KEY:781988e7-aca4-4dc0-b60f-1f4a1dcdc31a")
    suspend fun getSingleFilmById(@Path("id")id:Int):Response<SingleMovieData>



    @GET("/api/v1/staff")
    @Headers("X-API-KEY:781988e7-aca4-4dc0-b60f-1f4a1dcdc31a")
    suspend fun getFilmActorsByFilmId(@Query("filmId") filmId: Int):Response<Actors>

//    @GET("/api/v1/staff/{id}")
//    @Headers("X-API-KEY:781988e7-aca4-4dc0-b60f-1f4a1dcdc31a")
//    suspend fun getActors(@Path("id")id:Int):Response<ActorByIdRespons>


    @GET("api/v2.1/films/releases")
    @Headers("X-API-KEY:781988e7-aca4-4dc0-b60f-1f4a1dcdc31a")
    suspend fun getComingsoon(@Query("year")year:Int,@Query("month")month:String,@Query("page")page: Int):Response<ReleasesResponse>


}