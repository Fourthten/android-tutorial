package com.example.movielist.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ModelData(
    var id: String,
    var name: String,
    var desc: String,
    var poster: String,
    var img_preview: String
) : Parcelable