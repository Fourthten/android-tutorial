package com.example.movielist.ui.main.content.favorite.movie

import com.example.movielist.R
import com.example.movielist.data.source.local.entity.MovieEntity
import com.example.movielist.ui.detail.DetailMovieActivity
import com.example.movielist.ui.main.content.favorite.FavoriteViewModel
import com.example.movielist.ui.main.content.movie.MovieAdapter
import com.example.movielist.ui.main.content.movie.MovieCallback
import com.example.movielist.utils.Constants
import com.example.movielist.viewmodel.ViewModelFactory
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.empty_state.*
import kotlinx.android.synthetic.main.fragment_favorite_movie.*
import javax.inject.Inject

class FavoriteMovieFragment : DaggerFragment(), MovieCallback {

    private lateinit var viewModel: FavoriteViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()
        parentFragment?.let {
            viewModel = ViewModelProvider(it, factory)[FavoriteViewModel::class.java]
        }
        observeFavoriteMovies()

    }

    private fun observeFavoriteMovies() {
        viewModel.getListFavoriteMovie().observe(viewLifecycleOwner, Observer {
            if (it != null){
                rv_favorite_movie.adapter?.let {adapter ->
                    when (adapter) {
                        is MovieAdapter -> {
                            if (it.isNullOrEmpty()){
                                rv_favorite_movie.visibility = GONE
                                enableEmptyStateEmptyFavoriteMovie()
                            } else {
                                rv_favorite_movie.visibility = VISIBLE
                                adapter.submitList(it)
                                adapter.notifyDataSetChanged()
                            }
                        }
                    }
                }
            }
        })
    }
    private fun setupRecyclerView() {
        rv_favorite_movie.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MovieAdapter(this@FavoriteMovieFragment)
        }
    }
    private fun enableEmptyStateEmptyFavoriteMovie() {
        img_empty_state.setImageResource(R.drawable.ic_empty_state_favorite)
        img_empty_state.contentDescription =
            resources.getString(R.string.empty_movie)
        title_empty_state.text = resources.getString(R.string.empty_favorite)
        desc_empty_state.text =
            resources.getString(R.string.empty_movie)
        favorite_movie_empty_state.visibility = VISIBLE
    }
    override fun onItemClicked(data: MovieEntity) {
        startActivity(
            Intent(
                context,
                DetailMovieActivity::class.java
            )
                .putExtra(DetailMovieActivity.EXTRA_DATA, data.movieId)
                .putExtra(DetailMovieActivity.EXTRA_TYPE, Constants.TYPE_MOVIE)
        )
    }
}