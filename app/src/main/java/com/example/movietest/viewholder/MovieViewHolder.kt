package com.example.movietest.viewholder

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.movietest.R
import com.example.movietest.model.ResultCall

class MovieViewHolder(view: View) : ViewHolder(view) {
    private val movieItem = view.findViewById<CardView>(R.id.cardview)
    private val movieTitle = view.findViewById<TextView>(R.id.tvTitle)

    fun render(resultCall: ResultCall, onClick: (resultCall: ResultCall) -> Unit) {
        movieTitle.text = resultCall.original_title
        movieItem.setOnClickListener {
            onClick(resultCall)
        }
        movieTitle.setOnClickListener {
            onClick(resultCall)
        }
    }
}