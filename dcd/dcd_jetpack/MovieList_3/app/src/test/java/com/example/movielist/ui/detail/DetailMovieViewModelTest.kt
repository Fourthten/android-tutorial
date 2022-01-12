package com.example.movielist.ui.detail

import com.example.movielist.data.source.CatalogRepository
import com.example.movielist.data.source.local.entity.MovieEntity
import com.example.movielist.data.source.local.entity.TvShowEntity
import com.example.movielist.utils.DummyData
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {
    private val dummyMovie = DummyData.generateDataMovieDummy()[0]
    private val movieId = dummyMovie.movieId
    private val dummyTvShow = DummyData.generateDataTvShowDummy()[0]
    private val tvShowId = dummyTvShow.tvShowId
    private lateinit var viewModel: DetailMovieViewModel
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    @Mock
    private lateinit var catalogRepository: CatalogRepository
    @Mock
    private lateinit var observerMovie: Observer<MovieEntity>
    @Mock
    private lateinit var observerTvShow: Observer<TvShowEntity>
    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(catalogRepository)
    }

    @Test
    fun getMovieDetail() {
        val movieDummy = MutableLiveData<MovieEntity>()
        movieDummy.value = dummyMovie
        Mockito.`when`(catalogRepository.getMovieDetail(movieId)).thenReturn(movieDummy)
        val movieData = viewModel.getMovieDetail(movieId).value
        Assert.assertNotNull(movieData)
        assertEquals(dummyMovie.id, movieData?.id)
        assertEquals(dummyMovie.movieId, movieData?.movieId)
        assertEquals(dummyMovie.name, movieData?.name)
        assertEquals(dummyMovie.desc, movieData?.desc)
        assertEquals(dummyMovie.poster, movieData?.poster)
        assertEquals(dummyMovie.imgPreview, movieData?.imgPreview)
        viewModel.getMovieDetail(movieId).observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)
    }
    @Test
    fun getTvShowDetail() {
        val tvShowDummy = MutableLiveData<TvShowEntity>()
        tvShowDummy.value = dummyTvShow
        Mockito.`when`(catalogRepository.getTvShowDetail(tvShowId)).thenReturn(tvShowDummy)
        val tvShowData = viewModel.getTvShowDetail(tvShowId).value
        Assert.assertNotNull(tvShowData)
        assertEquals(dummyTvShow.id, tvShowData?.id)
        assertEquals(dummyTvShow.tvShowId, tvShowData?.tvShowId)
        assertEquals(dummyTvShow.name, tvShowData?.name)
        assertEquals(dummyTvShow.desc, tvShowData?.desc)
        assertEquals(dummyTvShow.poster, tvShowData?.poster)
        assertEquals(dummyTvShow.imgPreview, tvShowData?.imgPreview)
        viewModel.getTvShowDetail(tvShowId).observeForever(observerTvShow)
        verify(observerTvShow).onChanged(dummyTvShow)
    }
}