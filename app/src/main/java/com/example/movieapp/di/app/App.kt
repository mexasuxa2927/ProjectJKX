package com.example.movieapp.di.app

import android.app.Application
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.movieapp.viewmodul.MyViewModel
import dagger.hilt.android.HiltAndroidApp
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltAndroidApp
class  App : Application() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()


    }

}