package com.example.movielist.ui.main.content.tvshow

import com.example.movielist.R
import com.example.movielist.data.ModelData
import com.example.movielist.ui.detail.DetailMovieActivity
import com.example.movielist.ui.main.MainViewModel
import com.example.movielist.ui.main.content.DataAdapter
import com.example.movielist.ui.main.content.DataCallback
import com.example.movielist.utils.Helper.TYPE_TVSHOW
import com.example.movielist.viewmodel.ViewModelFactory
import android.content.Intent
import android.view.LayoutInflater
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_tv_show.*

class TvShowFragment : Fragment(), DataCallback {
    private lateinit var viewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
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
        viewModel.getListOnTheAirTvShows().observe(viewLifecycleOwner, Observer { listTvShow ->
            rv_tvshow.adapter.let { adapter ->
                when (adapter) {
                    is DataAdapter -> adapter.setData(listTvShow)
                }
            }
        })

    }

    private fun setupRecyclerView() {
        rv_tvshow.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = DataAdapter(this@TvShowFragment)
        }
    }

    override fun onItemClicked(data: ModelData) {
        startActivity(
            Intent(
                context,
                DetailMovieActivity::class.java
            )
                .putExtra(DetailMovieActivity.EXTRA_DATA, data.id)
                .putExtra(DetailMovieActivity.EXTRA_TYPE, TYPE_TVSHOW)
        )
    }
}
