package com.example.movielist.ui.detail

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import com.example.movielist.R
import com.example.movielist.model.ModelData
import com.example.movielist.utils.Helper.TYPE_MOVIE
import com.example.movielist.utils.Helper.TYPE_TVSHOW
import com.example.movielist.utils.Helper.setImageWithGlide
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.content_detail.*

class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var result: ModelData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        val viewModel = ViewModelProvider(
            this@DetailMovieActivity,
            ViewModelProvider.NewInstanceFactory()
        )[DetailMovieViewModel::class.java]

        setupToolbar()
        val id = intent.getStringExtra(EXTRA_DATA)
        val type = intent.getStringExtra(EXTRA_TYPE)

        if (type.equals(TYPE_MOVIE, ignoreCase = true)) {
            setupToolbarTitle(resources.getString(R.string.title_movie))
            id?.let {viewModel.setMovieId(it)}
            result = viewModel.getDetailMovieById()

        } else if (type.equals(TYPE_TVSHOW, ignoreCase = true)) {
            setupToolbarTitle(resources.getString(R.string.title_tvshow))
            id?.let {
                viewModel.setTvShowId(it)
            }
            result = viewModel.getDetailTvShowById()
        }

        tv_detail_name.text = result.name
        tv_detail_desc.text = result.desc
        setImageWithGlide(this@DetailMovieActivity, result.poster, img_detail_poster)
        setImageWithGlide(this@DetailMovieActivity, result.img_preview, img_detail_hightlight)
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