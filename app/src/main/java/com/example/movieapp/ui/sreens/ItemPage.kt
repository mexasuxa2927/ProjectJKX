package com.example.movieapp.ui.sreens

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.moive.SingleMovieData
import com.example.movieapp.databinding.FragmentItemPageBinding
import com.example.movieapp.ui.adapters.ActorsRecyclerViewAdapter
import com.example.movieapp.utils.RecyclerViewItemClickListner
import com.example.movieapp.viewmodul.MyViewModel
import com.google.android.material.transition.MaterialContainerTransform

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ItemPage.newInstance] factory method to
 * create an instance of this fragment.
 */
class ItemPage : Fragment(),RecyclerViewItemClickListner{
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val viewModel:MyViewModel by hiltNavGraphViewModels(R.id.mynav_host)


    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }
    private var binding: FragmentItemPageBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
       if(binding==null){
           binding =  FragmentItemPageBinding.inflate(layoutInflater,container,false)
       }
        loadData()



        return binding!!.root
    }

    private fun loadData() {
        loadActors()
        viewModel.getSingleMovieData().observe(viewLifecycleOwner){
            it.onSuccess {
                Glide.with(requireContext()).load(it.posterUrl).into(binding!!.imageFilmPoster)
                if(it.nameOriginal==""){
                    binding!!.filmTitle.title = it.nameRu
                    binding!!.filmTitleText.text = it.nameRu
                }
                else{
                    binding!!.filmTitle.title = it.nameOriginal
                    binding!!.filmTitleText.text = it.nameOriginal
                }
                it.genres.forEach{
                    binding!!.genres.text  = binding!!.genres.text.toString() + " "  + it.genre
                }
                binding!!.imdbReyting.text  = "IMDB :"+it.ratingImdb
                binding!!.kinopoistkReyting.text  = "Kino poisk :"+it.ratingKinopoisk
                binding!!.discription.text    =  it.description

            }.onFailure {


            }


        }

    }
    private lateinit var  adapter:ActorsRecyclerViewAdapter
    private fun loadActors() {
        binding!!.recyclerActoris.layoutManager = GridLayoutManager(requireContext(),3,GridLayoutManager.HORIZONTAL,false)
        adapter = ActorsRecyclerViewAdapter(this)
        binding!!.recyclerActoris.adapter  = adapter
        viewModel.getActorsByFilmId().observe(viewLifecycleOwner){
            it.onSuccess {
                adapter.submitList(it)
            }.onFailure {
                adapter.submitList(emptyList())
            }

        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ItemPage.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ItemPage().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun itemClickListner(dataId: Int) {
//        viewModel.fetchActorDataById(id)
//        findNavController().navigate(R.id.action_itemPage_to_actorPage)
    }
}