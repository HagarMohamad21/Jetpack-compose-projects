package com.example.jectpackcomposedemo.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface FavouriteDao {

//    @Query("SELECT * FROM fav_cities")
//    fun getAllCities(): Flow<List<Favourite>>
//
////    @Query("SELECT * FROM fav_cities WHERE city")
////    fun getFavById(id:Int)
//
//    @Insert(onConflict = REPLACE)
//    suspend fun addCityToFavs(favourite: Favourite)
//
//    @Delete
//    suspend fun deleteFav(favourite: Favourite)
//
//    @Query("DELETE  FROM fav_cities")
//    suspend fun deleteAll()



}