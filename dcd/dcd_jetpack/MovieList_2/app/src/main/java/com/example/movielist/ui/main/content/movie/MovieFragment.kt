package com.example.movielist.ui.main.content.movie

import com.example.movielist.R
import com.example.movielist.data.ModelData
import com.example.movielist.ui.detail.DetailMovieActivity
import com.example.movielist.ui.main.MainViewModel
import com.example.movielist.ui.main.content.DataAdapter
import com.example.movielist.ui.main.content.DataCallback
import com.example.movielist.utils.Helper.TYPE_MOVIE
import com.example.movielist.viewmodel.ViewModelFactory
import android.content.Intent
import android.view.LayoutInflater
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment(), DataCallback {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupRecyclerView()
        val factory = ViewModelFactory.getInstance()
        activity?.let {
            viewModel = ViewModelProvider(
                it,
                factory
            )[MainViewModel::class.java]
        }

        viewModel.getListNowPlayingMovies().observe(viewLifecycleOwner, Observer { listMovie ->
            rv_movie.adapter?.let { adapter ->
                when (adapter) {
                    is DataAdapter -> adapter.setData(listMovie)
                }
            }
        })

    }

    private fun setupRecyclerView() {
        rv_movie.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = DataAdapter(this@MovieFragment)
        }
    }

    override fun onItemClicked(data: ModelData) {
        startActivity(
            Intent(
                context,
                DetailMovieActivity::class.java
            )
                .putExtra(DetailMovieActivity.EXTRA_DATA, data.id)
                .putExtra(DetailMovieActivity.EXTRA_TYPE, TYPE_MOVIE)
        )
    }

}
