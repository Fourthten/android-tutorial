package com.example.movielist.ui.main.content.favorite

import com.example.movielist.R
import com.example.movielist.viewmodel.ViewModelFactory
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_favorite.*
import javax.inject.Inject

class FavoriteFragment : DaggerFragment() {
    private lateinit var viewModel: FavoriteViewModel
    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        context?.let { setupViewPager(it) }
        viewModel = ViewModelProvider(this@FavoriteFragment, factory)[FavoriteViewModel::class.java]
    }
    private fun setupViewPager(context: Context) {
        val sectionsPagerAdapter = SectionsPagerAdapter(context, childFragmentManager)
        favorite_view_pager.adapter = sectionsPagerAdapter
        favorite_tab_layout.setupWithViewPager(favorite_view_pager)
    }
}