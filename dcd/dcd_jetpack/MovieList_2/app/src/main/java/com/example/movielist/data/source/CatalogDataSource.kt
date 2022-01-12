package com.example.movielist.data.source

import androidx.lifecycle.LiveData
import com.example.movielist.data.ModelData

interface CatalogDataSource {
    fun getNowPlayingMovies(): LiveData<List<ModelData>>
    fun getMovieDetail(movieId: Int): LiveData<ModelData>
    fun getTvShowOnTheAir(): LiveData<List<ModelData>>
    fun getTvShowDetail(tvShowId: Int): LiveData<ModelData>
}