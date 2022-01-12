package com.example.movielist.ui.detail

import androidx.lifecycle.ViewModel
import com.example.movielist.model.ModelData
import com.example.movielist.utils.DummyData

class DetailMovieViewModel : ViewModel() {

    private lateinit var movieId: String
    private lateinit var tvShowId: String

    private fun getListMovie(): ArrayList<ModelData> = DummyData.generateDataMovieDummy() as ArrayList<ModelData>
    private fun getListTvShow(): ArrayList<ModelData> = DummyData.generateDataTvShowDummy() as ArrayList<ModelData>

    fun setMovieId(movieId: String){
        this.movieId = movieId
    }

    fun setTvShowId(tvShowId: String){
        this.tvShowId = tvShowId
    }

    fun getDetailMovieById(): ModelData {
        lateinit var result: ModelData
        val listMovie = getListMovie()
        for (movie in listMovie){
            if (movie.id == movieId){
                result = movie
                break
            }
        }
        return result
    }

    fun getDetailTvShowById(): ModelData {
        lateinit var result: ModelData
        val listTvShow = getListTvShow()
        for (tvShow in listTvShow){
            if (tvShow.id == tvShowId){
                result = tvShow
                break
            }
        }
        return result
    }

}