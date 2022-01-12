package com.example.movielist.ui.main

import org.junit.Before
import org.junit.Test
import junit.framework.TestCase.assertNotNull
import org.junit.Assert.assertEquals

class MainViewModelTest {
    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    // Ini test movie
    @Test
    fun getListMovie() {
        val movies = viewModel.getListMovie()
        assertNotNull(movies)
        assertEquals(10, movies.size)
    }

    // Ini test tv show
    @Test
    fun getListTvShow() {
        val tvShows = viewModel.getListTvShow()
        assertNotNull(tvShows)
        assertEquals(10, tvShows.size)
    }
}