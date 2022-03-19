package com.example.jectpackcomposedemo.data.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class WeatherApiResponse(
    @SerializedName("city")
    val city: City,
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("cod")
    val cod: String,
    @SerializedName("list")
    val list: List<WeatherItem>,
    @SerializedName("message")
    val message: Double
)