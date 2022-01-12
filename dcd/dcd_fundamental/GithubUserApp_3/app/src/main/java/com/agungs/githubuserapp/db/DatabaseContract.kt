package com.agungs.githubuserapp.db

import android.net.Uri
import android.provider.BaseColumns

internal class DatabaseContract {
    internal class UserColumns : BaseColumns {
        companion object {
            const val TABLE_NAME = "users"
            const val _ID = "_id"
            const val USERNAME = "username"
            const val FOLLOWERS = "followers"
            const val FOLLOWING = "following"
            const val TYPE = "type"
            const val AVATAR = "avatar"
            const val EMAIL = "email"
            const val LOCATION = "location"
            const val COMPANY = "company"

            val AUTHORITY = "com.agungs.githubuserapp"
            val SCHEME = "content"

            val CONTENT_URI: Uri = Uri.Builder().scheme(SCHEME)
                .authority(AUTHORITY)
                .appendPath(TABLE_NAME)
                .build()
        }
    }
}