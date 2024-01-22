package com.example.movieapp.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.movieapp.ui.sreens.ComingSoonPage
import com.example.movieapp.ui.sreens.HomePage
import com.example.movieapp.ui.sreens.PageFour
import com.example.movieapp.ui.sreens.SearchPage

class NavigationViewPagerAdapter(fm:FragmentManager):FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return 4
    }

    private val pageHome = HomePage()
    private val comingSoonPage = ComingSoonPage()
    private val searchPage = SearchPage()
    private val fourPage  = PageFour()


    override fun getItem(position: Int): Fragment {
        when(position){
            0->{return pageHome}
            1->{return comingSoonPage}
            2->{return searchPage}
            3->{return fourPage}
            else->{
                return pageHome
            }
        }
    }
}