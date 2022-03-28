package com.example.jectpackcomposedemo.presentation.screens.favourite

import androidx.lifecycle.ViewModel
import com.example.jectpackcomposedemo.domain.usecase.FavouriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class FavouriteViewModel @Inject constructor(private val useCase: FavouriteUseCase):ViewModel(){

//    private val _favouriteList=MutableStateFlow<List<Favourite>>(emptyList())
//    val favouriteList=_favouriteList.asStateFlow()
//
//
//    init {
//        viewModelScope.launch (Dispatchers.IO){
////           useCase.getAllFavs().distinctUntilChanged().collect{favs->
////               if(favs.isNullOrEmpty()){
////                   Log.e("TAG", ":EMPTY FAVS ", )
////               }
////               else _favouriteList.value=favs
////           }
//        }
//
//    }





}