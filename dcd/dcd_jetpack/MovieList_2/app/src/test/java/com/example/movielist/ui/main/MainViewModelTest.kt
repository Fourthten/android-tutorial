package com.example.movielist.ui.main

import com.example.movielist.data.ModelData
import com.example.movielist.data.source.CatalogRepository
import com.example.movielist.utils.DummyData
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {
    private val dummyMovie = DummyData.generateDataMovieDummy()
    private val dummyTvShow = DummyData.generateDataTvShowDummy()
    private lateinit var viewModel: MainViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @Mock
    private lateinit var catalogRepository: CatalogRepository
    @Mock
    private lateinit var observer: Observer<List<ModelData>>

    @Before
    fun setUp() {
        viewModel = MainViewModel(catalogRepository)
    }

    @Test
    fun getListNowPlayingMovies() {
        val movie = MutableLiveData<List<ModelData>>()
        movie.value = dummyMovie
        `when`(catalogRepository.getNowPlayingMovies()).thenReturn(movie)
        val dataListMovie = viewModel.getListNowPlayingMovies().value
        verify(catalogRepository).getNowPlayingMovies()
        assertNotNull(dataListMovie)
        assertEquals(10, dataListMovie?.size)
        viewModel.getListNowPlayingMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }

    @Test
    fun getListOnTheAirTvShows() {
        val tvShow = MutableLiveData<List<ModelData>>()
        tvShow.value = dummyTvShow
        `when`(catalogRepository.getTvShowOnTheAir()).thenReturn(tvShow)
        val dataListTvShow = viewModel.getListOnTheAirTvShows().value
        verify(catalogRepository).getTvShowOnTheAir()
        assertNotNull(dataListTvShow)
        assertEquals(10, dataListTvShow?.size)
        viewModel.getListOnTheAirTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}