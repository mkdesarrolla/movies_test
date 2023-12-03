package com.example.movietest.typeconverter

import androidx.room.TypeConverter

class TypeConverter {
//    @TypeConverter
//    fun fromListIntToString(intList: List<Int>): String = intList.toString()
//
//    @TypeConverter
//    fun toListIntFromString(stringList: String): List<Int> {
//        val result = ArrayList<Int>()
//        val split =stringList.replace("[","").replace("]","").replace(" ","").split(",")
//        for (n in split) {
//            try {
//                result.add(n.toInt())
//            } catch (e: Exception) {
//
//            }
//        }
//        return result
//    }
        @TypeConverter
        fun fromListInt(list: List<Int>): String {
            return list.joinToString(",")
        }

    @TypeConverter
    fun toListInt(data: String): List<Int> {
        return listOf(*data.split(",").map { it.toInt() }.toTypedArray())
    }
}