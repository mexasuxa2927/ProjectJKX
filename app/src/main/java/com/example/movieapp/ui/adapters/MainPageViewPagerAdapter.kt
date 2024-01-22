package com.example.movieapp.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.releases.Release


class MainPageViewPagerAdapter(private val itemsList: List<Release>,private var context:Context):PagerAdapter() {
    override fun getCount(): Int {
        return itemsList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object`
    }

    @SuppressLint("MissingInflatedId")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater  = LayoutInflater.from(context)
        var layout  = inflater.inflate(R.layout.viewpageritem,container,false)
        Glide.with(layout).load(itemsList[position].posterUrl).into(layout.findViewById(R.id.imageviewPagerAdapter))
        container.addView(layout)

        return layout
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }



}