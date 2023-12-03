package com.example.movietest.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movietest.model.MovieResponse
import com.example.movietest.prueba.MResponse
import com.example.movietest.prueba.ResultCall
import com.example.movietest.repository.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel: ViewModel() {
    var movieList = MResponse(0, listOf(ResultCall()), 0, 0)
    var movieListLiveData = MutableLiveData<MResponse>()

    private val movieRepository = MovieRepository()
    fun searchByName(movieTitle: String?) {
        Log.i("searchByName ViewModel", "Aquí llega")
        CoroutineScope(Dispatchers.Main).launch {
            movieListLiveData.value = movieRepository.getMovieByTitle(movieTitle)
        }
    }
}