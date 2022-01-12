package com.example.movielist.di.main

import com.example.movielist.di.main.favorite.FavoriteFragmentBuildersModule
import com.example.movielist.ui.main.content.favorite.FavoriteFragment
import com.example.movielist.ui.main.content.movie.MovieFragment
import com.example.movielist.ui.main.content.tvshow.TvShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeMovieFragment() : MovieFragment
    @ContributesAndroidInjector
    abstract fun contributeTvShowFragment() : TvShowFragment
    @ContributesAndroidInjector(modules = [FavoriteFragmentBuildersModule::class])
    abstract fun contributeFavoriteFragment() : FavoriteFragment
}