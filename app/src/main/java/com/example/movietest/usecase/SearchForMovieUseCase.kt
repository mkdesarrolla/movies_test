package com.example.movietest.usecase

import com.example.movietest.model.MovieResponse
import com.example.movietest.prueba.MResponse
import com.example.movietest.repository.MovieRepository

class SearchForMovieUseCase() {
    private val movieRepository = MovieRepository()
    suspend fun getMovieByName(movieTitle: String): MResponse{
        return movieRepository.getMovieByTitle(movieTitle)
    }
}