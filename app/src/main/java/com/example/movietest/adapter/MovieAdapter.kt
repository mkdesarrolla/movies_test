package com.example.movietest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movietest.R
import com.example.movietest.model.MResponse
import com.example.movietest.model.ResultCall
import com.example.movietest.viewholder.MovieViewHolder

class MovieAdapter(
    private val onClick: (ResultCall) -> Unit
) : RecyclerView.Adapter<MovieViewHolder>() {
    private var listOfMovies: List<ResultCall> = MResponse(0, listOf(), 0, 0).resultCalls

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(layoutInflater.inflate(R.layout.layout, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = listOfMovies[position]
        holder.render(item) {
            onClick.invoke(it)
        }
    }

    override fun getItemCount() = listOfMovies.size

    fun changeList(listInViewModel: List<ResultCall>) {
        listOfMovies = listInViewModel
        notifyDataSetChanged()
    }
}