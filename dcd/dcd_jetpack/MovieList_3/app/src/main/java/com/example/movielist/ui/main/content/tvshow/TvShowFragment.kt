package com.example.movielist.ui.main.content.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movielist.R
import com.example.movielist.data.source.local.entity.TvShowEntity
import com.example.movielist.ui.detail.DetailMovieActivity
import com.example.movielist.ui.main.MainViewModel
import com.example.movielist.utils.Constants.TYPE_TVSHOW
import com.example.movielist.viewmodel.ViewModelFactory
import com.example.movielist.vo.Status
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_tv_show.*
import kotlinx.android.synthetic.main.progress_bar.*
import javax.inject.Inject

class TvShowFragment : DaggerFragment(), TvShowCallback {
    private lateinit var viewModel: MainViewModel
    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()
        activity?.let { setupViewModel(it) }
        observeListTvShow()
    }
    private fun setupRecyclerView() {
        rv_tvshow.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TvShowAdapter(this@TvShowFragment)
        }
    }
    private fun setupViewModel(fragmentActivity: FragmentActivity) {
        fragmentActivity.let {
            viewModel = ViewModelProvider(
                it,
                factory
            )[MainViewModel::class.java]
        }
    }
    private fun observeListTvShow() {
        viewModel.getListOnTheAirTvShows().observe(viewLifecycleOwner, Observer { listTvShow ->
            if (listTvShow != null) {
                when (listTvShow.status) {
                    Status.LOADING -> progress_bar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        progress_bar.visibility = View.GONE
                        rv_tvshow.adapter?.let { adapter ->
                            when (adapter) {
                                is TvShowAdapter -> {
                                    adapter.submitList(listTvShow.data)
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
    override fun onItemClicked(data: TvShowEntity) {
        startActivity(
            Intent(
                context,
                DetailMovieActivity::class.java
            )
                .putExtra(DetailMovieActivity.EXTRA_DATA, data.tvShowId)
                .putExtra(DetailMovieActivity.EXTRA_TYPE, TYPE_TVSHOW)
        )
    }
}