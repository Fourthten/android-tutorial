package com.example.movielist.ui.main.content

import com.example.movielist.model.ModelData

interface DataCallback  {
    fun onItemClicked(data: ModelData)
}