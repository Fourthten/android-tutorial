package com.example.movielist.ui.main.content.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movielist.R

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movielist.model.ModelData
import com.example.movielist.ui.detail.DetailMovieActivity
import com.example.movielist.ui.main.MainViewModel
import com.example.movielist.ui.main.content.DataAdapter
import com.example.movielist.ui.main.content.DataCallback
import com.example.movielist.utils.Helper.TYPE_TVSHOW
import kotlinx.android.synthetic.main.fragment_tv_show.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TvShowFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TvShowFragment : Fragment(),
    DataCallback {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            viewModel = ViewModelProvider(
                it,
                ViewModelProvider.NewInstanceFactory()
            )[MainViewModel::class.java]
        }

        val listTvShow = viewModel.getListTvShow()
        setupRecyclerView(listTvShow)
    }

    private fun setupRecyclerView(data: List<ModelData>) {
        rv_tvshow.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = DataAdapter(this@TvShowFragment)
        }.also {
            it.adapter.let { adapter ->
                when (adapter) {
                    is DataAdapter -> {
                        adapter.setData(data)
                    }
                }
            }
        }
    }

    override fun onItemClicked(data: ModelData) {
        startActivity(
            Intent(context, DetailMovieActivity::class.java)
                .putExtra(DetailMovieActivity.EXTRA_DATA, data.id)
                .putExtra(DetailMovieActivity.EXTRA_TYPE, TYPE_TVSHOW)
        )
    }

}