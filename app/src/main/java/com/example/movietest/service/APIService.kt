package com.example.movietest.service

import com.example.movietest.model.MResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getMovie(@Url url: String): Response<MResponse>
}


