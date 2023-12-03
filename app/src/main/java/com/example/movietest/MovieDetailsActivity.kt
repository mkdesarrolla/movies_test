package com.example.movietest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.movietest.databinding.ActivityMovieDetailsBinding
import com.example.movietest.model.ResultCall
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        var movie: ResultCall = extras!!.getSerializable("movie") as ResultCall
        isMovieInDb(movie)

        binding.movieDetailsTitleTV.text = movie.original_title
        binding.movieDetailsOverViewTV.text = movie.overview

        binding.movieDetailsAddToFavouriteButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                MainActivity.database.movieDao().addMovieToFavourites(movie)
            }
        }
    }

    private fun isMovieInDb(movieToCheck: ResultCall){
        CoroutineScope(Dispatchers.IO).launch {
            var isMovieInDatabase = false
            val list = MainActivity.database.movieDao().getAllFavouriteMovies()
            list.forEach {
                if (it == movieToCheck){
                    isMovieInDatabase = !isMovieInDatabase
                }
            }
            if (isMovieInDatabase){
                runOnUiThread {
                    binding.movieDetailsAddToFavouriteButton.visibility = View.INVISIBLE
                }
            }
        }
    }
}