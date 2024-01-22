package com.example.movieapp.data.releases

data class Release(
    val countries: List<Country>,
    val duration: Int,
    val expectationsRating: Double,
    val expectationsRatingVoteCount: Int,
    val filmId: Int,
    val genres: List<Genre>,
    val nameEn: String,
    val nameRu: String,
    val posterUrl: String,
    val posterUrlPreview: String,
    val rating: Double,
    val ratingVoteCount: Int,
    val releaseDate: String,
    val year: Int
)