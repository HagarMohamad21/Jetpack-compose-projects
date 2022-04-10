package com.example.jectpackcomposedemo.presentation.screens.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.jectpackcomposedemo.data.datastore.PrefStore
import com.example.jectpackcomposedemo.data.model.WeatherApiResponse
import com.example.jectpackcomposedemo.domain.usecase.WeatherUseCase
import com.example.jectpackcomposedemo.utils.DataOrException
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel @Inject constructor
    (private val useCase: WeatherUseCase,
     private val prefStore: PrefStore): ViewModel() {

//    val weatherResponse :MutableState<DataOrException<WeatherApiResponse,Boolean,Exception> >
//    = mutableStateOf(DataOrException(null,true,Exception("")))



    suspend fun loadWeather(city:String,unit:String) :DataOrException<WeatherApiResponse,Boolean,Exception>{

         var result=DataOrException<WeatherApiResponse,Boolean,Exception>()
             result=useCase.invoke(city,unit)

        //  weatherResponse.value=result
         Log.e("TAG", "getWeather: ${result}", )
//          return@launch  useCase.invoke(city)

    return result}

     fun getUnitFromDataStore()=
        prefStore.getDegreeUnit()


}