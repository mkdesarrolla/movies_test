package com.example.movietest.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.movietest.R
import com.example.movietest.model.ResultCall

class MovieViewHolder(view: View) : ViewHolder(view) {
    private val movieItem = view.findViewById<CardView>(R.id.cardview)
    private val movieTitle = view.findViewById<TextView>(R.id.tvTitle)
    private val movieImage = view.findViewById<ImageView>(R.id.ivMovie)

    fun render(resultCall: ResultCall, onClick: (resultCall: ResultCall) -> Unit) {
        movieTitle.text = resultCall.original_title
        resultCall.poster_path.let {
            Glide.with(this.itemView).load("https://www.themoviedb.org/t/p/w94_and_h141_bestv2$it").into(movieImage)
        }
        movieItem.setOnClickListener {
            onClick(resultCall)
        }
        movieTitle.setOnClickListener {
            onClick(resultCall)
        }
    }
}