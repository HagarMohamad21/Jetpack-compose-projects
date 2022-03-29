package com.example.jectpackcomposedemo.domain.usecase

import com.example.jectpackcomposedemo.data.database.FavouritesRepository
import com.example.jectpackcomposedemo.data.model.City
import com.example.jectpackcomposedemo.domain.model.Favorite
import javax.inject.Inject

class FavouriteUseCase @Inject constructor(
private val favouritesRepository: FavouritesRepository
) {

   fun getAllFavs()=favouritesRepository.getAllCities()

suspend fun addCity(favorite: Favorite)=favouritesRepository.addCityToFavs(favorite)
   suspend fun hasItem(city: String)=favouritesRepository.hasItem(city)
    suspend fun removeCity(city: Favorite) {
        favouritesRepository.deleteFav(city)
    }
}