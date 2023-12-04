package com.example.movietest

import com.example.movietest.dao.MovieDAO
import com.example.movietest.model.ResultCall
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.verify


class InsertMovieInDBTest {
    val dao: MovieDAO = mock()
    private val resultCall = ResultCall()
    @Test
    fun insertMovieInDB(){
        dao.addMovieToFavourites(resultCall)
        verify(dao).addMovieToFavourites(resultCall)
    }
}