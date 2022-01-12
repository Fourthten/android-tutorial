package com.example.movielist.di

import com.example.movielist.di.main.MainFragmentBuildersModule
import com.example.movielist.ui.detail.DetailMovieActivity
import com.example.movielist.ui.main.MainHomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector(modules = [MainFragmentBuildersModule::class])
    abstract fun contributeHomeActivity(): MainHomeActivity
    @ContributesAndroidInjector
    abstract fun contributeDetailActivity(): DetailMovieActivity
}