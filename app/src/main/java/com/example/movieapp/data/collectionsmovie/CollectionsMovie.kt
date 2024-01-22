package com.example.movieapp.data.collectionsmovie

data class CollectionsMovie(
    val items: List<CollectionsMovieItem>,
    val total: Int,
    val totalPages: Int
)