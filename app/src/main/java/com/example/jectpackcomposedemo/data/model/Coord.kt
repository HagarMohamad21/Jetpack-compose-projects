package com.example.jectpackcomposedemo.data.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Coord(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double
)