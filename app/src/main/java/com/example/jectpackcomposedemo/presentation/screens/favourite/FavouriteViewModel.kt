package com.example.jectpackcomposedemo.presentation.screens.favourite

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jectpackcomposedemo.domain.model.Favorite
import com.example.jectpackcomposedemo.domain.usecase.FavouriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FavouriteViewModel @Inject constructor(private val useCase: FavouriteUseCase):ViewModel(){

    private val _favouriteList= MutableStateFlow<List<Favorite>>(emptyList())
    val favouriteList=_favouriteList.asStateFlow()


    init {
        viewModelScope.launch (Dispatchers.IO){
           useCase.getAllFavs().distinctUntilChanged().collect{favs->
               if(favs.isNullOrEmpty()){
                   _favouriteList.value= emptyList()
                   Log.e("TAG", ":EMPTY FAVS ", )
               }
               else _favouriteList.value=favs
           }
        }
    }

    fun addCityToFavs(city: Favorite){
        viewModelScope.launch (Dispatchers.IO){
            useCase.addCity(city)
        }
    }
   fun removeCity(city:Favorite){
       viewModelScope.launch(Dispatchers.IO) {
           useCase.removeCity(city)
       }
   }
}