package com.example.movieapp.ui.sreens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentHomePageBinding
import com.example.movieapp.ui.adapters.HorizontalRecyclerAdapter
import com.example.movieapp.ui.adapters.MainPageViewPagerAdapter
import com.example.movieapp.utils.GatePageTransformer
import com.example.movieapp.utils.RecyclerViewItemClickListner
import com.example.movieapp.viewmodul.MyViewModel
import com.google.android.material.transition.Hold

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomePage.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomePage : Fragment(),RecyclerViewItemClickListner {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }
    private  var binding: FragmentHomePageBinding? = null
    private val viewmodel:MyViewModel by hiltNavGraphViewModels(R.id.mynav_host)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        return if(binding!=null){
            binding?.root
        }else{
        // Inflate the layout for this fragment
        binding  = FragmentHomePageBinding.inflate(layoutInflater,container,false)

            setDataViewPager()
            setdataRecyclerViewTopFilms()
            setdataRecyclerViewTopTvShow()
            setdataRecyclerViewTopKind()
            setdataRecyclerViewVampireTheme()
            setdataRecyclerViewFamilyTheme()
            setdataRecyclerViewZombieTheme()
            setdataRecyclerViewComicsTheme()

            binding?.root

        }
    }

    private fun setdataRecyclerViewComicsTheme() {
        val adapter = HorizontalRecyclerAdapter(this)
        binding!!.recyclerCOMICSTHEME.layoutManager  = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding!!.recyclerCOMICSTHEME.adapter  = adapter
        viewmodel.getTopKindOfComicTheme().observe(viewLifecycleOwner){
            it.onSuccess {
                adapter.submitList(it)
            }.onFailure {
                adapter.submitList(emptyList())
            }
        }
    }

    private fun setdataRecyclerViewZombieTheme() {
        val adapter = HorizontalRecyclerAdapter(this)
        binding!!.recyclerZOMBIETHEME.layoutManager  = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding!!.recyclerZOMBIETHEME.adapter  = adapter
        viewmodel.getTopKindOfZombieTheme().observe(viewLifecycleOwner){
            it.onSuccess {
                adapter.submitList(it)
            }.onFailure {
                adapter.submitList(emptyList())
            }
        }
    }

    private fun setdataRecyclerViewFamilyTheme() {
        val adapter = HorizontalRecyclerAdapter(this)
        binding!!.recyclerFAMILY.layoutManager  = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding!!.recyclerFAMILY.adapter  = adapter
        viewmodel.getTopKindOfFamilyTheme().observe(viewLifecycleOwner){
            it.onSuccess {
                adapter.submitList(it)
            }.onFailure {
                adapter.submitList(emptyList())
            }
        }
    }

    private fun setdataRecyclerViewVampireTheme() {
        val adapter = HorizontalRecyclerAdapter(this)
        binding!!.recyclerVampireTheme.layoutManager  = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding!!.recyclerVampireTheme.adapter  = adapter
        viewmodel.getTopKindOfVampireTheme().observe(viewLifecycleOwner){
            it.onSuccess {
                adapter.submitList(it)
            }.onFailure {
                adapter.submitList(emptyList())
            }
        }

    }

    private fun setdataRecyclerViewTopKind() {
        val adapter = HorizontalRecyclerAdapter(this)
        binding!!.recyclerTopAnimation.layoutManager  = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding!!.recyclerTopAnimation.adapter  = adapter
        viewmodel.getTopKindOfAnimation().observe(viewLifecycleOwner){
            it.onSuccess {
                adapter.submitList(it)
            }.onFailure {
                adapter.submitList(emptyList())
            }
        }

    }

    private fun setdataRecyclerViewTopTvShow() {
        val adapter  = HorizontalRecyclerAdapter(this)
        binding!!.recyclerToptvShows.layoutManager  =LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding!!.recyclerToptvShows.adapter  = adapter
        viewmodel.getTopTvShow().observe(viewLifecycleOwner){
            it.onSuccess {
                adapter.submitList(it)
            }.onFailure {
                adapter.submitList(emptyList())
            }
        }
    }


    private fun setdataRecyclerViewTopFilms() {
        val adapter  = HorizontalRecyclerAdapter(this)
        binding!!.recyclerTopfilms.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding!!.recyclerTopfilms.adapter  = adapter
        viewmodel.getTopMovieByType().observe(viewLifecycleOwner){
            it.onSuccess {
                adapter.submitList(it)
            }.onFailure {
                adapter.submitList(emptyList())
            }

        }


    }

    lateinit var myVPAdapter: MainPageViewPagerAdapter
    private fun setDataViewPager() {
        binding!!.viewpagerReleases.setPageTransformer(true,GatePageTransformer())
       viewmodel.getListReleases().observe(viewLifecycleOwner){
           it.onSuccess {

               myVPAdapter =MainPageViewPagerAdapter(it,requireContext())
               binding!!.viewpagerReleases.adapter =  myVPAdapter
               binding!!.dotindicator.setViewPager(binding!!.viewpagerReleases)
           }.onFailure {
                Toast.makeText(requireContext(),"Something went wrong!!",Toast.LENGTH_LONG).show()
           }
       }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomePage().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun itemClickListner(dataId: Int) {
        Log.d("@@@@", "itemClickListner:id=$dataId ")
        viewmodel.fetchSingleMovieData(dataId)
        viewmodel.fetchActorsByFilmId(dataId)
        findNavController().navigate(R.id.action_mainScreen_to_itemPage)
    }
}