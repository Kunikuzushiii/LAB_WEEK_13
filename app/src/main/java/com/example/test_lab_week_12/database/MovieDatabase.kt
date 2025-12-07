package com.example.test_lab_week_12.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import com.example.test_lab_week_12.model.Movie
import android.content.Context

@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        @Volatile
        private var instance: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase {
            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context,
                    MovieDatabase::class.java,
                    "movie-db"
                ).build().also { instance = it }
            }
        }
    }
}
