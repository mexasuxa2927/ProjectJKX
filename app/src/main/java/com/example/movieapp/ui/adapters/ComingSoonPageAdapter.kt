package com.example.movieapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.data.releases.Release
import com.example.movieapp.databinding.MoviePosterItemForRecyclerviewBinding


class ComingSoonPageAdapter : PagingDataAdapter<Release, ComingSoonPageAdapter.MyViewHolderComingSoon>(MyDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderComingSoon {
        val binding = MoviePosterItemForRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolderComingSoon(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolderComingSoon, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class MyViewHolderComingSoon(private val binding: MoviePosterItemForRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Release) {
            Glide.with(binding.root.context).load(item.posterUrl).into(binding.posterImage)
            
        }
    }


    class MyDiffCallback : DiffUtil.ItemCallback<Release>() {
        override fun areItemsTheSame(oldItem: Release, newItem: Release): Boolean {
            return oldItem.filmId == newItem.filmId
        }

        override fun areContentsTheSame(oldItem: Release, newItem: Release): Boolean {
            return oldItem == newItem
        }
    }
}


