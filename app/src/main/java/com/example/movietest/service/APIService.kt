package com.example.movietest.service

import com.example.movietest.model.MovieResponse
import com.example.movietest.prueba.MResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import retrofit2.http.Url

interface APIService {
    @GET
//    suspend fun getMovie(@Url url: String): Response<MovieResponse>
    suspend fun getMovie(@Url url: String): Response<MResponse>
}

//https://api.themoviedb.org/3/search/movie?query=Jack+Reacher&api_key=2c4f2811e9e5eb1da8c4938eb2f43de6

