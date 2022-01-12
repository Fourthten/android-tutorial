package com.example.movielist.data.source.remote.api

import com.example.movielist.data.source.remote.response.ListResponse
import com.example.movielist.data.source.remote.response.MovieResponse
import com.example.movielist.data.source.remote.response.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
//private val Api_key: String = "77f9eff1d930501888ad96d010df59f3"

interface ApiService {
    @GET("movie/now_playing")
    fun getNowPlayingMovies(
        @Query("api_key") apiKey: String = "77f9eff1d930501888ad96d010df59f3"
    ) : Call<ListResponse<MovieResponse>>

    @GET("movie/{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = "77f9eff1d930501888ad96d010df59f3"
    ) : Call<MovieResponse>

    @GET("tv/on_the_air")
    fun getTvShowOnTheAir(
        @Query("api_key") apiKey: String = "77f9eff1d930501888ad96d010df59f3"
    ) : Call<ListResponse<TvShowResponse>>

    @GET("tv/{tv_id}")
    fun getDetailTvShow(
        @Path("tv_id") tvShowId: Int,
        @Query("api_key") apiKey: String = "77f9eff1d930501888ad96d010df59f3"
    ) : Call<TvShowResponse>
}