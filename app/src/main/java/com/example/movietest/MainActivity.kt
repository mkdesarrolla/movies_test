package com.example.movietest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.movietest.adapter.MovieAdapter
import com.example.movietest.database.MovieDatabase
import com.example.movietest.databinding.ActivityMainBinding
import com.example.movietest.model.MResponse
import com.example.movietest.model.ResultCall
import com.example.movietest.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mRecyclerView : RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private val movieViewModel: MovieViewModel by viewModels()
    private var movieList = MResponse(0, listOf(ResultCall()), 0, 0).resultCalls

    companion object {
        lateinit var database: MovieDatabase
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        swipeRefreshLayout = binding.swipe
        database =  Room.databaseBuilder(this, MovieDatabase::class.java, "movies-db").build()


        val adapter = MovieAdapter{
            val intent = Intent(this@MainActivity, MovieDetailsActivity::class.java)
            intent.putExtra("movie", it)
            startActivity(intent)
        }

        setUpRecyclerView(adapter)

        movieViewModel.movieListLiveData.observe(this) {
            adapter.changeList(it.resultCalls)
            movieList = it.resultCalls
        }

        binding.idSV.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                movieViewModel.searchByName(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                onQueryTextSubmit(newText)
                return false
            }
        })

        binding.toFavouriteMoviesButton.setOnClickListener {
            goToFavouriteMoviesActivity()
        }

        swipeRefreshLayout.setOnRefreshListener {
            adapter.changeList(emptyList())
            if (swipeRefreshLayout.isRefreshing) {
                swipeRefreshLayout.isRefreshing = false;
            }
        }
    }

    private fun setUpRecyclerView(adapter: MovieAdapter) {
        mRecyclerView = binding.movieRV
        mRecyclerView.setHasFixedSize(false)
        binding.movieRV.adapter = adapter
        binding.movieRV.layoutManager = LinearLayoutManager(this)
    }

    private fun goToFavouriteMoviesActivity(){
        val intent = Intent(this@MainActivity, FavouriteMoviesActivity::class.java)
        startActivity(intent)
    }
}