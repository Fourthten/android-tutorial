package com.example.movielist.ui.detail

import org.junit.Before
import org.junit.Test
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import com.example.movielist.utils.DummyData

class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DummyData.generateDataMovieDummy()[0]
    private val dummyTvShow = DummyData.generateDataTvShowDummy()[0]
    private val movieId = dummyMovie.id
    private val tvShowId = dummyTvShow.id

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel()
        viewModel.setMovieId(movieId)
        viewModel.setTvShowId(tvShowId)
    }

    // Ini test detail movie
    @Test
    fun getDetailMovieById() {
        val movie = viewModel.getDetailMovieById()
        assertNotNull(movie)
        assertEquals(dummyMovie.name, movie.name)
        assertEquals(dummyMovie.desc, movie.desc)
        assertEquals(dummyMovie.poster, movie.poster)
        assertEquals(dummyMovie.img_preview, movie.img_preview)
    }

    // Ini test detail tv show
    @Test
    fun getDetailTvShowById() {
        val tvShow = viewModel.getDetailTvShowById()
        assertNotNull(tvShow)
        assertEquals(dummyTvShow.name, tvShow.name)
        assertEquals(dummyTvShow.desc, tvShow.desc)
        assertEquals(dummyTvShow.poster, tvShow.poster)
        assertEquals(dummyTvShow.img_preview, tvShow.img_preview)
    }
}