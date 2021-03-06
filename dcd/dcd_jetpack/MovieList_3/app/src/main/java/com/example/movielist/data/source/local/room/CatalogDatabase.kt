package com.example.movielist.data.source.local.room

import com.example.movielist.data.source.local.entity.MovieEntity
import com.example.movielist.data.source.local.entity.TvShowEntity
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MovieEntity::class, TvShowEntity::class], version = 1, exportSchema = false)
abstract class CatalogDatabase : RoomDatabase() {
    abstract fun catalogDao(): CatalogDao
    companion object {
        @Volatile
        private var INSTANCE: CatalogDatabase? = null
        fun getInstance(context: Context): CatalogDatabase =
        INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                CatalogDatabase::class.java,
                "catalog.db"
            ).build()
        }
    }
}