package com.agungs.githubuserapp.helper

import android.database.Cursor
import com.agungs.githubuserapp.db.DatabaseContract
import com.agungs.githubuserapp.model.Users

object MappingHelper {

    fun mapCursorToArrayList(usersCursor: Cursor?): ArrayList<Users> {
        val listUsers = ArrayList<Users>()
        usersCursor?.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(DatabaseContract.UserColumns._ID))
                val username = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.USERNAME))
                val followers = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.FOLLOWERS))
                val following = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.FOLLOWING))
                val type = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.TYPE))
                val avatar = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.AVATAR))
                val company = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.COMPANY))
                val location = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.LOCATION))
                val email = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.EMAIL))
                listUsers.add(Users(id, username, followers, following, type, avatar, email, location, company))
            }
        }
        return listUsers
    }

    fun mapCursorToDetail(usersCursor: Cursor?): Users {
        var listUsers = Users()
        usersCursor?.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(DatabaseContract.UserColumns._ID))
                val username = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.USERNAME))
                val followers = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.FOLLOWERS))
                val following = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.FOLLOWING))
                val type = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.TYPE))
                val avatar = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.AVATAR))
                val company = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.COMPANY))
                val location = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.LOCATION))
                val email = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.EMAIL))
                listUsers = Users(id, username, followers, following, type, avatar, email, location, company)
            }
        }
        return listUsers
    }
}