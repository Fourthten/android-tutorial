package com.example.movielist.ui.main

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.example.movielist.R
import com.example.movielist.utils.DummyData

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4

@RunWith(AndroidJUnit4::class)
class MainHomeActivityTest {
    private val dummyMovie = DummyData.generateDataMovieDummy()
    private val dummyTvShow = DummyData.generateDataTvShowDummy()

    @get:Rule
    var activityRule = ActivityTestRule(MainHomeActivity::class.java)

    @Test
    fun loadMovieAndTvShow() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
        onView(withId(R.id.nav_tvshow)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
        onView(withId(R.id.nav_movie)).perform(click())
    }

    @Test
    fun detailMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(6))
        onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(6, click()))
        onView(withId(R.id.img_detail_hightlight)).check(matches(isDisplayed()))
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_name)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_name)).check(matches(withText(dummyMovie[6].name)))
        onView(withId(R.id.tv_detail_desc)).check(matches(withText(dummyMovie[6].desc)))
        pressBack()
    }

    @Test
    fun detailTvShow() {
        onView(withId(R.id.nav_tvshow)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(6))
        onView(withId(R.id.rv_tvshow))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(6, click()))
        onView(withId(R.id.img_detail_hightlight)).check(matches(isDisplayed()))
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_name)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_name)).check(matches(withText(dummyTvShow[6].name)))
        onView(withId(R.id.tv_detail_desc)).check(matches(withText(dummyTvShow[6].desc)))
        pressBack()
    }
}