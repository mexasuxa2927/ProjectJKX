package com.example.movieapp.di.app

import android.app.Application
import com.example.movieapp.viewmodul.MyViewModel
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}