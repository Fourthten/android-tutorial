package com.example.movielist.ui.main

import com.example.movielist.R
import com.example.movielist.viewmodel.ViewModelFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main_home.*

class MainHomeActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)
        val factory = ViewModelFactory.getInstance()
        viewModel = ViewModelProvider(
            this@MainHomeActivity,
            factory
        )[MainViewModel::class.java]
        setupToolbar()
        setupViewPager()
    }

    private fun setupToolbar() {
        setSupportActionBar(main_toolbar)
        supportActionBar?.elevation = 0f
        supportActionBar?.title = resources.getString(R.string.app_name)
    }

    private fun setupViewPager() {
        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        main_view_pager.adapter = sectionPagerAdapter
        main_tablayout.setupWithViewPager(main_view_pager)
    }
}
