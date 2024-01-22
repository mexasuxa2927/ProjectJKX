package com.example.movieapp.repository

import com.example.movieapp.network.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private  val apiService: ApiService) {

    fun getNetworkApi(): ApiService {
        return    apiService
    }
}