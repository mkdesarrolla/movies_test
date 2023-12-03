package com.example.movietest.typeconverter

import androidx.room.TypeConverter

class TypeConverter {
        @TypeConverter
        fun fromListInt(list: List<Int>): String {
            return list.joinToString(",")
        }

    @TypeConverter
    fun toListInt(data: String): List<Int> {
        return listOf(*data.split(",").map { it.toInt() }.toTypedArray())
    }
}