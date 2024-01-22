package com.example.movieapp.data.moive

data class SingleMovieData(
    val completed: Boolean,
    val countries: List<Country>,
    val coverUrl: Any,
    val description: String,
    val editorAnnotation: Any,
    val endYear: Any,
    val filmLength: Int,
    val genres: List<Genre>,
    val has3D: Boolean,
    val hasImax: Boolean,
    val imdbId: String,
    val isTicketsAvailable: Boolean,
    val kinopoiskHDId: Any,
    val kinopoiskId: Int,
    val lastSync: String,
    val logoUrl: Any,
    val nameEn: Any,
    val nameOriginal: String,
    val nameRu: String,
    val posterUrl: String,
    val posterUrlPreview: String,
    val productionStatus: Any,
    val ratingAgeLimits: Any,
    val ratingAwait: Int,
    val ratingAwaitCount: Int,
    val ratingFilmCritics: Int,
    val ratingFilmCriticsVoteCount: Int,
    val ratingGoodReview: Int,
    val ratingGoodReviewVoteCount: Int,
    val ratingImdb: Int,
    val ratingImdbVoteCount: Int,
    val ratingKinopoisk: Double,
    val ratingKinopoiskVoteCount: Int,
    val ratingMpaa: String,
    val ratingRfCritics: Int,
    val ratingRfCriticsVoteCount: Int,
    val reviewsCount: Int,
    val serial: Boolean,
    val shortDescription: Any,
    val shortFilm: Boolean,
    val slogan: Any,
    val startYear: Any,
    val type: String,
    val webUrl: String,
    val year: Int
)