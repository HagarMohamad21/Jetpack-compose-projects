package com.example.jectpackcomposedemo.domain.usecase

import com.example.jectpackcomposedemo.data.repository.WeatherRepository
import javax.inject.Inject

class WeatherUseCase @Inject constructor(private val repository: WeatherRepository) {

    suspend operator fun invoke(city: String,unit:String) =repository.getWeather(city,unit)

}