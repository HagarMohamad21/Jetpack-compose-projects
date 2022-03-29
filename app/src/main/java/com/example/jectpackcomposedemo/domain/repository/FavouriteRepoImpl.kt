package com.example.jectpackcomposedemo.domain.repository

import com.example.jectpackcomposedemo.data.database.FavouriteDao
import com.example.jectpackcomposedemo.data.database.FavouritesRepository
import com.example.jectpackcomposedemo.data.model.City
import com.example.jectpackcomposedemo.domain.model.Favorite
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavouriteRepoImpl  @Inject constructor(private val dao: FavouriteDao) : FavouritesRepository {
    override fun getAllCities(): Flow<List<Favorite>> =dao.getAllCities()

    override suspend fun addCityToFavs(favourite: Favorite) =dao.addCityToFavs(favourite)

    override suspend fun deleteFav(favourite: Favorite) =dao.deleteFav(favourite)

    override suspend fun deleteAll() =dao.deleteAll()

    override suspend fun hasItem(city: String)=dao.isCityFavorite(city)
}