package com.example.jectpackcomposedemo.data.database

import com.example.jectpackcomposedemo.domain.model.Favorite
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Singleton
interface FavouritesRepository {

    fun getAllCities(): Flow<List<Favorite>>

//    @Query("SELECT * FROM fav_cities WHERE city")
//    fun getFavById(id:Int)


    suspend fun addCityToFavs(favourite: Favorite)


    suspend fun deleteFav(favourite: Favorite)

    suspend fun deleteAll()
    suspend fun hasItem(city: String): Boolean
}