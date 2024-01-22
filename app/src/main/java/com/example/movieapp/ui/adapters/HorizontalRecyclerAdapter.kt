package com.example.movieapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.collectionsmovie.CollectionsMovieItem
import com.example.movieapp.databinding.MoviePosterItemForRecyclerviewBinding
import com.example.movieapp.utils.RecyclerViewItemClickListner


class HorizontalRecyclerAdapter(val listner: RecyclerViewItemClickListner):ListAdapter<CollectionsMovieItem,HorizontalRecyclerAdapter.MyViewHolder>(MyDifUtil()) {

    lateinit var imageView: ImageView
    lateinit var cardView: CardView
    inner class MyViewHolder(itemView: View): ViewHolder(itemView){

        fun onBindItem(data:CollectionsMovieItem){
            imageView = itemView.findViewById(R.id.posterImage)
            cardView = itemView.findViewById(R.id.container)
            cardView.setOnClickListener {
                listner.itemClickListner(data.kinopoiskId)
            }
            var animation:Animation = AnimationUtils.loadAnimation(itemView.context,R.anim.zoom_in_out_animation)
            cardView.startAnimation(animation)
            Glide.with(itemView.context).load(data.posterUrl).into(imageView)

        }
    }

    class MyDifUtil(): DiffUtil.ItemCallback<CollectionsMovieItem>() {
        override fun areItemsTheSame(oldItem: CollectionsMovieItem, newItem: CollectionsMovieItem): Boolean {
            return oldItem.nameEn==newItem.nameEn
        }

        override fun areContentsTheSame(oldItem: CollectionsMovieItem, newItem: CollectionsMovieItem): Boolean {
            return oldItem==newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_poster_item_for_recyclerview,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBindItem(getItem(position))
    }

}