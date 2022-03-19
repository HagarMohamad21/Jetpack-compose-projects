package com.example.jectpackcomposedemo.presentation.screens.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jectpackcomposedemo.data.model.WeatherApiResponse
import com.example.jectpackcomposedemo.domain.usecase.WeatherUseCase
import com.example.jectpackcomposedemo.utils.DataOrException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel @Inject constructor(private val useCase: WeatherUseCase):ViewModel() {

//    val weatherResponse :MutableState<DataOrException<WeatherApiResponse,Boolean,Exception> >
//    = mutableStateOf(DataOrException(null,true,Exception("")))


    suspend fun loadWeather(city:String) :DataOrException<WeatherApiResponse,Boolean,Exception>{
         var result=DataOrException<WeatherApiResponse,Boolean,Exception>()
             result=useCase.invoke(city)

        //  weatherResponse.value=result
         Log.e("TAG", "getWeather: ${result}", )
//          return@launch  useCase.invoke(city)

    return result}

}