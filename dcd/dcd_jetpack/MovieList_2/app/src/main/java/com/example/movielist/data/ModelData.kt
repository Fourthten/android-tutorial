package com.example.movielist.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ModelData(
    var id: Int = 0,
    var name: String? = null,
    var desc: String? = null,
    var poster: String? = null,
    var img_preview: String? = null
) : Parcelable