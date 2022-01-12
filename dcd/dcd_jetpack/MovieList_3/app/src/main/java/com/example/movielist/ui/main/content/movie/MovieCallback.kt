package com.example.movielist.ui.main.content.movie

import com.example.movielist.data.source.local.entity.MovieEntity

interface MovieCallback {
    fun onItemClicked(data: MovieEntity)
}