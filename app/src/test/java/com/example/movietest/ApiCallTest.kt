package com.example.movietest

import com.example.movietest.model.MResponse
import com.example.movietest.model.ResultCall
import com.example.movietest.repository.MovieRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class ApiCallTest {
    val repo: MovieRepository = mock()

    @Test
    fun mockApiResponse(){
        val call = ResultCall()
        call.original_title = "Avatar"
        val response = MResponse(1, listOf(call),0,0)
        CoroutineScope(Dispatchers.IO).launch {
            val prueba = Mockito.`when`(repo.getMovieByTitle("Avatar")).thenReturn(response)
            assertEquals(call,prueba)
        }
    }
}