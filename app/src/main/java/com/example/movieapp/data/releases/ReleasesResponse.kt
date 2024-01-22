package com.example.movieapp.data.releases

data class ReleasesResponse(
    val page: Int,
    val releases: List<Release>,
    val total: Int
)