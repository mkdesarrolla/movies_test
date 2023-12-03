package com.example.movietest.repository

import android.util.Log
import com.example.movietest.model.MResponse
import com.example.movietest.model.ResultCall
import com.example.movietest.service.APIService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRepository {
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/search/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getApi(): APIService {
        return getRetrofit().create(APIService::class.java)
    }

    suspend fun getMovieByTitle(movieTitle: String?): MResponse {
        val call = getApi().getMovie("movie?query=$movieTitle&api_key=2c4f2811e9e5eb1da8c4938eb2f43de6")
        if (call.isSuccessful){
            return call.body()!!
        } else {
            Log.i("Call unsuccessful", "Algo ha salido mal")
        }
        return MResponse(0, listOf(ResultCall()), 0, 0)
    }
}