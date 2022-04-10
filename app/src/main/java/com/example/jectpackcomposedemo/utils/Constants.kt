package com.example.jectpackcomposedemo.utils

import com.example.jectpackcomposedemo.data.model.WeatherItem

object Constants{

   const val IMPERIAL: String="imperial"
    const val METRIC: String="metric"
    const val STANDARD: String="standard"
     val unitsList= listOf(IMPERIAL, METRIC, STANDARD)

    const val API_KEY="ed60fcfbd110ee65c7150605ea8aceea"
    const val BASE_URL="https://api.openweathermap.org/"
    const val Image_BASE_URL="https://openweathermap.org/img/wn/"
    const val defaultCity="Cairo"


}

fun getImageUrl(weatherItem:WeatherItem)="${Constants.Image_BASE_URL}${weatherItem.weather[0].icon}@2x.png"