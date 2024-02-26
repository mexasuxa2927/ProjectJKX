package com.example.movieapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.data.movie_creaters.ActorsItem
import com.example.movieapp.databinding.ActorsItemViewBinding
import com.example.movieapp.utils.RecyclerViewItemClickListner

class ActorsRecyclerViewAdapter(val itemClickListner: RecyclerViewItemClickListner):ListAdapter<ActorsItem,ActorsRecyclerViewAdapter.MyViewHolderActors>(MyDifUtils()) {

    inner class MyViewHolderActors(var binding: ActorsItemViewBinding): RecyclerView.ViewHolder(binding.root){

    }


    private class MyDifUtils(): DiffUtil.ItemCallback<ActorsItem>() {
        override fun areItemsTheSame(oldItem: ActorsItem, newItem: ActorsItem): Boolean {
            return oldItem.staffId.equals(newItem.staffId)
        }

        override fun areContentsTheSame(oldItem: ActorsItem, newItem: ActorsItem): Boolean {
            return oldItem==newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderActors {
        val binding  =ActorsItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolderActors(binding)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: MyViewHolderActors, position: Int) {
        var actor =  getItem(position)
           holder.apply {
               Glide.with(binding.root.context).load(actor.posterUrl).into(binding.actorPhoto)
               binding.nameActor.text  = actor.nameRu
               binding.jobActor.text = actor.professionText
               binding.containers.setOnClickListener {
                   itemClickListner.itemClickListner(actor.staffId)
               }

           }
    }


}