package com.example.movielist.ui.main.content.tvshow

import com.example.movielist.data.source.local.entity.TvShowEntity

interface TvShowCallback {
    fun onItemClicked(data: TvShowEntity)
}