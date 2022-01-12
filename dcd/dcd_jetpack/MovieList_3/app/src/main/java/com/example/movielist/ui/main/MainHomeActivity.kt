package com.example.movielist.ui.main

import com.example.movielist.R
import com.example.movielist.viewmodel.ViewModelFactory
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main_home.*
import javax.inject.Inject
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.support.DaggerAppCompatActivity

class MainHomeActivity : DaggerAppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)
        setupToolbar()
        setupViewModel()
        setupNavigationController()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this@MainHomeActivity,
            factory
        )[MainViewModel::class.java]
    }
    private fun setupToolbar() {
        setSupportActionBar(main_toolbar)
        supportActionBar?.elevation = 0F
    }
    private fun setupNavigationController() {
        val navView: BottomNavigationView = findViewById(R.id.bottom_navbar)
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_movie,
            R.id.navigation_tvshow,
            R.id.navigation_favorite
        ).build()
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}
