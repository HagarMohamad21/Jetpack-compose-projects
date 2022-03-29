package com.example.jectpackcomposedemo.domain.repository

import com.example.jectpackcomposedemo.data.api.WeatherService
import com.example.jectpackcomposedemo.data.model.WeatherApiResponse
import com.example.jectpackcomposedemo.data.repository.WeatherRepository
import com.example.jectpackcomposedemo.utils.DataOrException
import javax.inject.Inject

class WeatherRepoImpl @Inject constructor(private val apiService:WeatherService):WeatherRepository {

    override suspend fun getWeather(city: String): DataOrException<WeatherApiResponse, Boolean, Exception> {
      val response=try {
          apiService.getWeather(query=city )
      }
      catch (e:Exception) {return DataOrException(e=e, loading = false)
      }
        return DataOrException(data = response,loading = false)
    }

}