package com.example.movielist.ui.detail

import com.example.movielist.data.source.CatalogRepository
import com.example.movielist.data.source.local.entity.MovieEntity
import com.example.movielist.data.source.local.entity.TvShowEntity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class DetailMovieViewModel @Inject constructor(private val catalogRepository: CatalogRepository) :
    ViewModel() {
    fun getMovieDetail(movieId: Int): LiveData<MovieEntity> =
        catalogRepository.getMovieDetail(movieId)
    fun getTvShowDetail(tvShowId: Int): LiveData<TvShowEntity> =
        catalogRepository.getTvShowDetail(tvShowId)
    fun setFavoriteMovie(movie: MovieEntity){
        catalogRepository.setFavoriteMovie(movie)
    }
    fun setFavoriteTvShow(tvShow: TvShowEntity){
        catalogRepository.setFavoriteTvShow(tvShow)
    }
}