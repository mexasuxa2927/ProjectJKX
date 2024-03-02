package com.example.movieapp.ui

import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.movieapp.R
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject


@AndroidEntryPoint
class  MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setCurrentData()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setCurrentData() {
        val currentDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM")
        val formattedDateTime = currentDateTime.format(formatter)
        val shared =  getSharedPreferences("data", 0)
        val editor  = shared.edit()
        val list = formattedDateTime.split("-")
        editor.putString("month",month(list[1]))
        editor.putInt("year",list[0].toInt())
        editor.apply()
        editor.commit()
    }
//    JANUARY
//    FEBRUARY
//    MARCH
//    APRIL
//    MAY
//    JUNE
//    JULY
//    AUGUST
//    SEPTEMBER
//    OCTOBER
//    NOVEMBER
//    DECEMBER

    private fun month(string:String):String{
        when(string){
            "01"->{return "JANUARY"}
            "02"->{return "FEBRUARY"}
            "03"->{return "MARCH"}
            "04"->{return "APRIL"}
            "05"->{return "MAY"}
            "06"->{return "JUNE"}
            "07"->{return "JULY"}
            "08"->{return "AUGUST"}
            "09"->{return "SEPTEMBER"}
            "10"->{return "OCTOBER"}
            "11"->{return "NOVEMBER"}
            "12"->{return "DECEMBER"}
            else->{
                return "JANUARY"
            }
        }


    }



}