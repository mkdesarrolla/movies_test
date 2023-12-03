package com.example.movietest.model

data class MovieResponse(
    val genres: List<Genre>,
    val original_title: String,
    val overview: String
)