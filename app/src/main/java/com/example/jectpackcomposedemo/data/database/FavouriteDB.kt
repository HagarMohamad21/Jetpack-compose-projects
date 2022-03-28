package com.example.jectpackcomposedemo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jectpackcomposedemo.domain.model.Favorite


@Database(entities = [Favorite::class], version = 2, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase() {
   //abstract fun weatherDao(): WeatherDao
}