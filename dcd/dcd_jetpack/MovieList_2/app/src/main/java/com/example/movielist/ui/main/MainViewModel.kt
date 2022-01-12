package com.example.movielist.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movielist.data.ModelData
import com.example.movielist.data.source.CatalogRepository

class MainViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {
    fun getListNowPlayingMovies(): LiveData<List<ModelData>> = catalogRepository.getNowPlayingMovies()
    fun getListOnTheAirTvShows(): LiveData<List<ModelData>> = catalogRepository.getTvShowOnTheAir()
}