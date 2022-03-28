package com.example.jectpackcomposedemo.domain.repository

import com.example.jectpackcomposedemo.data.database.FavouriteDao
import com.example.jectpackcomposedemo.data.database.FavouritesRepository
import javax.inject.Inject

class FavouriteRepoImpl  @Inject constructor(private val dao: FavouriteDao) : FavouritesRepository {
//    override fun getAllCities(): Flow<List<Favourite>> =dao.getAllCities()
//
//    override suspend fun addCityToFavs(favourite: Favourite) =dao.addCityToFavs(favourite)
//
//    override suspend fun deleteFav(favourite: Favourite) =dao.deleteFav(favourite)
//
//    override suspend fun deleteAll() =dao.deleteAll()
}