package com.example.movielist.ui.main.content

import com.example.movielist.data.ModelData

interface DataCallback  {
    fun onItemClicked(data: ModelData)
}