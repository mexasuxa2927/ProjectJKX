package com.example.movieapp.ui.sreens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentActorPageBinding
import com.example.movieapp.viewmodul.MyViewModel
import kotlin.math.log

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ActorPage.newInstance] factory method to
 * create an instance of this fragment.
 */
class ActorPage : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val viewmodel:MyViewModel  by hiltNavGraphViewModels(R.id.mynav_host)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    private  var binding:FragmentActorPageBinding?  = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        if(binding==null){
            binding  = FragmentActorPageBinding.inflate(layoutInflater,container,false)
        }
        loadData()


        return binding!!.root
    }

    private fun loadData() {
        viewmodel.getActorDataById().observe(viewLifecycleOwner){
            it.onSuccess {
                Log.d("@@@@", "loadData: ")
                Glide.with(requireContext()).load(it.posterUrl).into(binding!!.actorImage)
                binding!!.actorName.text  = it.nameRu
                binding!!.professions.text  = it.profession
                binding!!.actorFacts.text  = it.facts.toString()
            }.onFailure {
                Log.d("@@@@", "loadData:error")
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
         * @return A new instance of fragment ActorPage.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ActorPage().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}