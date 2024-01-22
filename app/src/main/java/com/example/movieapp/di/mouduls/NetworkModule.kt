package com.example.movieapp.di.mouduls

import com.example.movieapp.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideGsonConverter(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideDataApiService(gsonConverterFactory: GsonConverterFactory): ApiService {

        return Retrofit.Builder().baseUrl("https://kinopoiskapiunofficial.tech/").addConverterFactory(gsonConverterFactory).build().create(ApiService::class.java)
    }


}