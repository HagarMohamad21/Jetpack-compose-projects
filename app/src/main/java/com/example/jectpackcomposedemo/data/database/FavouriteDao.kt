package com.example.jectpackcomposedemo.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.jectpackcomposedemo.data.model.City
import com.example.jectpackcomposedemo.domain.model.Favorite
import kotlinx.coroutines.flow.Flow


@Dao
interface FavouriteDao {

    @Query("SELECT * FROM fav_cities")
    fun getAllCities(): Flow<List<Favorite>>

    @Insert(onConflict = REPLACE)
    suspend fun addCityToFavs(favourite: Favorite)

    @Delete
    suspend fun deleteFav(favourite: Favorite)

    @Query("DELETE  FROM fav_cities")
    suspend fun deleteAll()

    @Query("SELECT EXISTS(SELECT * FROM fav_cities WHERE city = :city)")
    fun isCityFavorite(city : String) : Boolean



}