package com.agungs.githubuserapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Users (
    var username: String? = "",
    var name: String? = "",
    var location: String? = "",
    var repository: String? = "",
    var company: String? = "",
    var followers: String? = "",
    var following: String? = "",
    var avatar: String? = ""
): Parcelable