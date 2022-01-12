package com.example.movielist.ui.main.content.favorite

import com.example.movielist.data.source.CatalogRepository
import com.example.movielist.data.source.local.entity.MovieEntity
import com.example.movielist.data.source.local.entity.TvShowEntity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(private val catalogRepository: CatalogRepository) : ViewModel() {
    fun getListFavoriteMovie(): LiveData<PagedList<MovieEntity>> = catalogRepository.getListFavoriteMovies()
    fun getListFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> = catalogRepository.getListFavoriteTvShows()
}