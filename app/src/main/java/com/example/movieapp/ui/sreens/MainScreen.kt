package com.example.movieapp.ui.sreens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMainScreenBinding
import com.example.movieapp.ui.adapters.NavigationViewPagerAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainScreen : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var  adapter:NavigationViewPagerAdapter?  = null

    private var savedViewInstance: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(adapter==null){
            adapter  = NavigationViewPagerAdapter(childFragmentManager)
        }

        Log.d("@@@@", "onCreate: ")
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    lateinit var binding :FragmentMainScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment


        Log.d("@@@@", "onCreateView: ")

        return if (savedViewInstance != null) {
            Log.d("#####", "onCreateView:  if")
            savedViewInstance
        } else {
            Log.d("#####", "onCreateView:  else ")
            binding  = FragmentMainScreenBinding.inflate(layoutInflater,container,false)
            setViewPager()
            setBottomNavigation()
            setDrower()
            savedViewInstance =binding.root
            savedViewInstance
        }



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("@@@@", "onViewCreated: ")
    }

    override fun onStart() {
        super.onStart()
        Log.d("@@@@", "onStart: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d("@@@@", "onPause: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d("@@@@", "onResume: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("@@@@", "onDestroy: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("@@@@", "onDestroyView: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d("@@@@", "onStop: ")
    }

    private fun setBottomNavigation() {
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home_nave_id->{
                    binding.NoswipeViewPager.currentItem  =0
                    true
                }
                R.id.come_nave_id->{
                    binding.NoswipeViewPager.currentItem  =1
                    true
                }
                R.id.search_nave_id->{
                    binding.NoswipeViewPager.currentItem  =2
                    true
                }
                R.id.down_nave_id->{
                    binding.NoswipeViewPager.currentItem  =3
                    true
                }

             else->{  false }
            }
        }
    }

    private fun setViewPager() {
        binding.NoswipeViewPager.adapter =  adapter
        Log.d("####", "setViewPager: ")
        binding.NoswipeViewPager.setSwipeEnabled(false)
    }

    private fun setDrower() {
        binding.menuBtn.setOnClickListener {
            binding.drower.open()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainScreen1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainScreen().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}