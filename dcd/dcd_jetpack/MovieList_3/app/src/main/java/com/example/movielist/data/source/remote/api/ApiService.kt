package com.example.movielist.data.source.remote.api

import com.example.movielist.data.source.remote.response.ListResponse
import com.example.movielist.data.source.remote.response.MovieResponse
import com.example.movielist.data.source.remote.response.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/now_playing")
    fun getNowPlayingMovies(
        @Query("api_key") apiKey: String = "77f9eff1d930501888ad96d010df59f3"
    ) : Call<ListResponse<MovieResponse>>
    @GET("tv/on_the_air")
    fun getTvShowOnTheAir(
        @Query("api_key") apiKey: String = "77f9eff1d930501888ad96d010df59f3"
    ) : Call<ListResponse<TvShowResponse>>
}