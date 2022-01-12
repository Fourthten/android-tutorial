package com.example.movielist.ui.detail

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.content_detail.*
import com.example.movielist.R
import com.example.movielist.data.ModelData
import com.example.movielist.utils.Helper.API_IMAGE_ENDPOINT
import com.example.movielist.utils.Helper.ENDPOINT_POSTER_SIZE_W185
import com.example.movielist.utils.Helper.ENDPOINT_POSTER_SIZE_W780
import com.example.movielist.utils.Helper.TYPE_MOVIE
import com.example.movielist.utils.Helper.TYPE_TVSHOW
import com.example.movielist.utils.Helper.setImageWithGlide
import com.example.movielist.viewmodel.ViewModelFactory

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "extra_type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(
            this@DetailMovieActivity,
            factory
        )[DetailMovieViewModel::class.java]
        setupToolbar()

        val id = intent.getIntExtra(EXTRA_DATA, 0)
        val type = intent.getStringExtra(EXTRA_TYPE)

        if (type.equals(TYPE_MOVIE, ignoreCase = true)) {
            setupToolbarTitle(resources.getString(R.string.title_movie))
            viewModel.getMovieDetail(id).observe(this, Observer {
                displayData(it)
            })
        } else if (type.equals(TYPE_TVSHOW, ignoreCase = true)) {
            setupToolbarTitle(resources.getString(R.string.title_tvshow))
            viewModel.getTvShowDetail(id).observe(this, Observer {
                it?.let {
                    displayData(it)
                }
            })
        }
    }

    private fun displayData(data: ModelData) {
        tv_detail_name.text = data.name
        tv_detail_desc.text = data.desc
        setImageWithGlide(
            this@DetailMovieActivity,
            API_IMAGE_ENDPOINT + ENDPOINT_POSTER_SIZE_W185 + data.poster,
            img_detail_poster
        )
        setImageWithGlide(
            this@DetailMovieActivity,
            API_IMAGE_ENDPOINT + ENDPOINT_POSTER_SIZE_W780 + data.img_preview,
            img_detail_hightlight
        )

    }

    private fun setupToolbar() {
        setSupportActionBar(detail_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        collapsing_toolbar.setExpandedTitleColor(Color.TRANSPARENT)
    }

    private fun setupToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}
