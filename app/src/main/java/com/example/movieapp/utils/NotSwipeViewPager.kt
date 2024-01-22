package com.example.movieapp.utils

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class NotSwipeViewPager (context: Context, attrs: AttributeSet? = null) : ViewPager(context, attrs) {

    private var isSwipeEnabled = true

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return isSwipeEnabled && super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return isSwipeEnabled && super.onInterceptTouchEvent(event)
    }

    fun setSwipeEnabled(enabled: Boolean) {
        isSwipeEnabled = enabled
    }
}