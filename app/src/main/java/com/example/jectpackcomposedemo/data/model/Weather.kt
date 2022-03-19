package com.example.jectpackcomposedemo.data.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Weather(
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val main: String
)