package com.example.movielist.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movielist.R
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movielist.ui.main.content.movie.MovieFragment
import com.example.movielist.ui.main.content.tvshow.TvShowFragment
import kotlinx.android.synthetic.main.activity_main_home.*

class MainHomeActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)
        viewModel = ViewModelProvider(
            this@MainHomeActivity,
            ViewModelProvider.NewInstanceFactory()
        )[MainViewModel::class.java]

        setupToolbar()
        setupBottomNavBar()
    }

    private fun setupToolbar() {
        setSupportActionBar(main_toolbar)
        supportActionBar?.elevation = 8F
    }

    private fun setupBottomNavBar() {
        val movieFragment = MovieFragment()
        val tvShowFragment = TvShowFragment()

        setActiveFragment(movieFragment, resources.getString(R.string.title_movie))

        bottom_navbar.setNavigationChangeListener { view, _ ->
            when (view.id) {
                R.id.nav_movie -> setActiveFragment(
                    movieFragment,
                    resources.getString(R.string.title_movie)
                )
                R.id.nav_tvshow -> setActiveFragment(
                    tvShowFragment,
                    resources.getString(R.string.title_tvshow)
                )
            }
        }
    }

    private fun setActiveFragment(fragment: Fragment, title: String) {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().apply {
            replace(R.id.container_main_fragment, fragment)
        }.commit()

        setActionBarTitle(title)
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}
