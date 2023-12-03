package com.example.movietest.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.movietest.prueba.ResultCall

@Dao
interface MovieDAO {
    @Query("Select * from resultcall_entity")
    fun getAllFavouriteMovies(): MutableList<ResultCall>

    @Insert
    fun addMovieToFavourites(movieEntity : ResultCall):Long
}