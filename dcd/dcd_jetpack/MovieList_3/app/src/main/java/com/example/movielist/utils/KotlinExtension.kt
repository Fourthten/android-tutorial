package com.example.movielist.utils

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movielist.R
import android.widget.ImageView

fun ImageView.loadFromUrl(path: String) {
    Glide.with(this).clear(this)
    Glide.with(this)
        .setDefaultRequestOptions(RequestOptions()
            .placeholder(R.drawable.ic_movie)
            .error(R.drawable.ic_movie)
        ).load(path).into(this)
}