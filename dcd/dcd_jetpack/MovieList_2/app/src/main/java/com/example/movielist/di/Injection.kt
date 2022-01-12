package com.example.movielist.di

import com.example.movielist.data.source.CatalogRepository
import com.example.movielist.data.source.remote.RemoteDataSource

object Injection {

    fun provideCatalogRepository(): CatalogRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return CatalogRepository.getInstance(remoteDataSource)
    }
}