package com.example.movielist.ui.main

import com.example.movielist.data.source.CatalogRepository
import com.example.movielist.data.source.local.entity.MovieEntity
import com.example.movielist.data.source.local.entity.TvShowEntity
import com.example.movielist.vo.Resource
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import javax.inject.Inject

class MainViewModel @Inject constructor(private val catalogRepository: CatalogRepository) :
    ViewModel() {
    fun getListNowPlayingMovies(): LiveData<Resource<PagedList<MovieEntity>>> = catalogRepository.getNowPlayingMovies()
    fun getListOnTheAirTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> = catalogRepository.getTvShowOnTheAir()
}