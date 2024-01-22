package com.example.movieapp.utils

import android.view.View
import androidx.viewpager.widget.ViewPager

class GatePageTransformer : ViewPager.PageTransformer {
    override fun transformPage(view: View, position: Float) {
        val width = view.width.toFloat()
        val scaleFactor = 0.45f
        val scale = if (position < 0) {
            1 + position * (1 - scaleFactor)
        } else {
            1 - position * (1 - scaleFactor)
        }

        view.pivotX = if (position < 0) width else 0f
        view.scaleX = scale
    }
}