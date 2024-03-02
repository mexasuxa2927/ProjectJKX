package com.example.movieapp.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.movieapp.network.ApiService
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private  val apiService: ApiService, @ApplicationContext val context: Context) {

    fun getShared(): SharedPreferences? {
        return context.getSharedPreferences("data",0)
    }
    fun getNetworkApi(): ApiService {
        return    apiService
    }
}