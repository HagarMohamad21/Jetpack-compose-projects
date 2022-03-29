package com.example.jectpackcomposedemo.data.database

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jectpackcomposedemo.domain.model.Favorite



@Database(entities = [Favorite::class], version = 2, exportSchema = false)
abstract class FavouriteDB: RoomDatabase() {
abstract fun getDao(): FavouriteDao

}