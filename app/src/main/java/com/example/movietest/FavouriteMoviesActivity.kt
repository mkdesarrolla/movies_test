package com.example.movietest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movietest.adapter.MovieAdapter
import com.example.movietest.databinding.ActivityFavouriteMoviesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouriteMoviesActivity : AppCompatActivity() {
    private lateinit var mRecyclerView : RecyclerView

    private lateinit var binding: ActivityFavouriteMoviesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavouriteMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MovieAdapter{
            val intent = Intent(this@FavouriteMoviesActivity, MovieDetailsActivity::class.java)
            intent.putExtra("movie", it)
            startActivity(intent)
        }
        setUpRecyclerView(adapter)

        CoroutineScope(Dispatchers.IO).launch {
            val list = MainActivity.database.movieDao().getAllFavouriteMovies()
            runOnUiThread {
                adapter.changeList(list)
            }
        }

    }
    private fun setUpRecyclerView(adapter: MovieAdapter) {
        mRecyclerView = binding.favouriteMoviesRV
        mRecyclerView.setHasFixedSize(false)
        binding.favouriteMoviesRV.adapter = adapter
        binding.favouriteMoviesRV.layoutManager = LinearLayoutManager(this)
    }
}


