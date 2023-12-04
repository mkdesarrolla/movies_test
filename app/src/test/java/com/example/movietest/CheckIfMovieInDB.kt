package com.example.movietest

import com.example.movietest.dao.MovieDAO
import com.example.movietest.database.MovieDatabase
import com.example.movietest.model.ResultCall
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class CheckIfMovieInDB {
    private var dao: MovieDAO = mock()
    private var db: MovieDatabase = mock()
    private val resultCall = ResultCall()
    private val list = mutableListOf<ResultCall>()

    @Test
    fun checkIfMovieInDB(){
        dao.addMovieToFavourites(resultCall)
        whenever(dao.getAllFavouriteMovies()).thenReturn(list)
    }
}