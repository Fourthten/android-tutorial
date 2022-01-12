package com.example.movielist.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movielist.data.ModelData
import com.example.movielist.data.source.CatalogRepository

class DetailMovieViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {

    fun getMovieDetail(movieId: Int): LiveData<ModelData> = catalogRepository.getMovieDetail(movieId)
    fun getTvShowDetail(tvShowId: Int): LiveData<ModelData> = catalogRepository.getTvShowDetail(
        tvShowId
    )
}