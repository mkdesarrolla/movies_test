package com.example.movietest.prueba

import com.google.gson.annotations.SerializedName

data class MResponse(
    val page: Int,
    @SerializedName("results") val resultCalls: List<ResultCall>,
    val total_pages: Int,
    val total_results: Int
)