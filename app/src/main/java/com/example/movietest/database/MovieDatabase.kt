package com.example.movietest.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.movietest.dao.MovieDAO
import com.example.movietest.model.ResultCall
import com.example.movietest.typeconverter.TypeConverter

@TypeConverters(TypeConverter::class)
@Database(entities = arrayOf(ResultCall::class), version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDAO
}