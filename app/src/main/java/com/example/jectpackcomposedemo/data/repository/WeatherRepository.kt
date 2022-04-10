package com.example.jectpackcomposedemo.data.repository

import com.example.jectpackcomposedemo.data.model.WeatherApiResponse
import com.example.jectpackcomposedemo.utils.DataOrException


interface WeatherRepository {
    suspend fun getWeather(city: String,unit:String): DataOrException<WeatherApiResponse,Boolean,Exception>
}