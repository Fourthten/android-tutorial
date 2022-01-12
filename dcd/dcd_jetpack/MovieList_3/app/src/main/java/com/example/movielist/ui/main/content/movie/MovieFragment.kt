package com.example.movielist.ui.main.content.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movielist.R
import com.example.movielist.data.source.local.entity.MovieEntity
import com.example.movielist.ui.detail.DetailMovieActivity
import com.example.movielist.ui.main.MainViewModel
import com.example.movielist.utils.Constants.TYPE_MOVIE
import com.example.movielist.viewmodel.ViewModelFactory
import com.example.movielist.vo.Status
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.progress_bar.*
import javax.inject.Inject

class MovieFragment : DaggerFragment(), MovieCallback {
    private lateinit var viewModel: MainViewModel
    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()
        activity?.let { setupViewModel(it) }
        observeListMovies()
    }

    private fun setupViewModel(fragmentActivity: FragmentActivity) {
        viewModel = ViewModelProvider(fragmentActivity, factory)[MainViewModel::class.java]
    }

    private fun observeListMovies() {
        viewModel.getListNowPlayingMovies().observe(viewLifecycleOwner, Observer { listMovie ->
            if (listMovie != null) {
                when (listMovie.status) {
                    Status.LOADING -> progress_bar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        progress_bar.visibility = View.GONE
                        rv_movie.adapter?.let { adapter ->
                            when (adapter) {
                                is MovieAdapter -> {
                                    adapter.submitList(listMovie.data)
                                    adapter.notifyDataSetChanged()
                                }
                            }
                        }
                    }
                    Status.ERROR -> {
                        progress_bar.visibility = View.GONE
                        Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun setupRecyclerView() {
        rv_movie.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MovieAdapter(this@MovieFragment)
        }
    }

    override fun onItemClicked(data: MovieEntity) {
        startActivity(
            Intent(
                context,
                DetailMovieActivity::class.java
            )
                .putExtra(DetailMovieActivity.EXTRA_DATA, data.movieId)
                .putExtra(DetailMovieActivity.EXTRA_TYPE, TYPE_MOVIE)
        )
    }

}