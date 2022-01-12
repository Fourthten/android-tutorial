package com.agungs.githubuserapp.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.agungs.githubuserapp.db.DatabaseContract.UserColumns.Companion.TABLE_NAME

internal class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "dbgithubuserapp"
        private const val DATABASE_VERSION = 1
        private const val SQL_CREATE_TABLE_USER = "CREATE TABLE $TABLE_NAME" +
                " (${DatabaseContract.UserColumns._ID} INTEGER PRIMARY KEY NOT NULL," +
                " ${DatabaseContract.UserColumns.USERNAME} TEXT NOT NULL," +
                " ${DatabaseContract.UserColumns.FOLLOWERS} TEXT NULL," +
                " ${DatabaseContract.UserColumns.FOLLOWING} TEXT NULL," +
                " ${DatabaseContract.UserColumns.TYPE} TEXT NULL," +
                " ${DatabaseContract.UserColumns.AVATAR} TEXT NULL," +
                " ${DatabaseContract.UserColumns.EMAIL} TEXT NULL,"+
                " ${DatabaseContract.UserColumns.LOCATION} TEXT NULL,"+
                " ${DatabaseContract.UserColumns.COMPANY} TEXT NULL)"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_TABLE_USER)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}