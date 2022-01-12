package com.agungs.githubuserapp.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.agungs.githubuserapp.db.DatabaseContract.UserColumns.Companion.TABLE_NAME
import com.agungs.githubuserapp.db.DatabaseContract.UserColumns.Companion.AUTHORITY
import com.agungs.githubuserapp.db.DatabaseContract.UserColumns.Companion.CONTENT_URI
import com.agungs.githubuserapp.db.UserHelper

class UsersProvider : ContentProvider() {

    companion object {
        private lateinit var userHelper: UserHelper
        private val sUriMatcher = UriMatcher(UriMatcher.NO_MATCH)
        private const val USER = 1

        init {
            sUriMatcher.addURI(AUTHORITY, TABLE_NAME, USER)
        }
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        val deleted: Int = 0
        return deleted
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }

    override fun onCreate(): Boolean {
        userHelper = UserHelper.getInstance(context as Context)
        userHelper.open()
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        return userHelper.queryAll()
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        val updated: Int = 0
        return updated
    }
}
