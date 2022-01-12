package com.example.movielist.di.main.favorite

import com.example.movielist.ui.main.content.favorite.movie.FavoriteMovieFragment
import com.example.movielist.ui.main.content.favorite.tvshow.FavoriteTvShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FavoriteFragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeFavoriteMovieFragment() : FavoriteMovieFragment
    @ContributesAndroidInjector
    abstract fun contributeFavoriteTvShowFragment() : FavoriteTvShowFragment
}