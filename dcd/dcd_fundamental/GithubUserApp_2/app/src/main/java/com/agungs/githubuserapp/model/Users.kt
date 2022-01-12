package com.agungs.githubuserapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Users (
    var id: Int? = 0,
    var username: String? = "",
    var followers: String? = "",
    var following: String? = "",
    var type: String? = "",
    var avatar: String? = "",
    var email: String? = "",
    var location: String? = ""
): Parcelable