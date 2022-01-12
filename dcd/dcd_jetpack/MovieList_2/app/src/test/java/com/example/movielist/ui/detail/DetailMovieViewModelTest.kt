package com.example.movielist.ui.detail

import com.example.movielist.data.ModelData
import com.example.movielist.data.source.CatalogRepository
import com.example.movielist.utils.DummyData
import com.nhaarman.mockitokotlin2.verify
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
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
class DetailMovieViewModelTest {
    private val dummyMovie = DummyData.generateDataMovieDummy()[0]
    private val movieId = dummyMovie.id
    private val dummyTvShow = DummyData.generateDataTvShowDummy()[0]
    private val tvShowId = dummyTvShow.id
    private lateinit var viewModel: DetailMovieViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    @Mock
    private lateinit var catalogRepository: CatalogRepository
    @Mock
    private lateinit var observer: Observer<ModelData>
    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(catalogRepository)
    }

    @Test
    fun getMovieDetail() {
        val movieDummy = MutableLiveData<ModelData>()
        movieDummy.value = dummyMovie
        `when`(catalogRepository.getMovieDetail(movieId)).thenReturn(movieDummy)
        val movieData = viewModel.getMovieDetail(movieId).value as ModelData
        assertNotNull(movieData)
        assertEquals(dummyMovie.id, movieData.id)
        assertEquals(dummyMovie.name, movieData.name)
        assertEquals(dummyMovie.desc, movieData.desc)
        assertEquals(dummyMovie.poster, movieData.poster)
        assertEquals(dummyMovie.img_preview, movieData.img_preview)
        viewModel.getMovieDetail(movieId).observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }

    @Test
    fun getTvShowDetail() {
        val tvShowDummy = MutableLiveData<ModelData>()
        tvShowDummy.value = dummyTvShow
        `when`(catalogRepository.getTvShowDetail(tvShowId)).thenReturn(tvShowDummy)
        val tvShowData = viewModel.getTvShowDetail(tvShowId).value as ModelData
        assertNotNull(tvShowData)
        assertEquals(dummyTvShow.id, tvShowData.id)
        assertEquals(dummyTvShow.name, tvShowData.name)
        assertEquals(dummyTvShow.desc, tvShowData.desc)
        assertEquals(dummyTvShow.poster, tvShowData.poster)
        assertEquals(dummyTvShow.img_preview, tvShowData.img_preview)
        viewModel.getTvShowDetail(tvShowId).observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}