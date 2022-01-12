package com.example.movielist.ui.main

import androidx.lifecycle.ViewModel
import com.example.movielist.model.ModelData
import com.example.movielist.utils.DummyData

class MainViewModel : ViewModel() {
    fun getListMovie(): List<ModelData> = DummyData.generateDataMovieDummy()
    fun getListTvShow(): List<ModelData> = DummyData.generateDataTvShowDummy()
}