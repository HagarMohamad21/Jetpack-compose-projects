package com.example.jectpackcomposedemo.data.api

import com.example.jectpackcomposedemo.data.model.WeatherApiResponse
import com.example.jectpackcomposedemo.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherService {

    @GET("data/2.5/forecast/daily")
    suspend fun getWeather(
        @Query("q") query:String,
        @Query("appid")appId:String=Constants.API_KEY,
        @Query("units") units:String=Constants.IMPERIAL
    ):WeatherApiResponse
}