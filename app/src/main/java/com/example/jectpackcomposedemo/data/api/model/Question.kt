package com.example.jectpackcomposedemo.data.api.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Question(
    @SerializedName("answer")
    val answer: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("choices")
    val choices: List<String>,
    @SerializedName("question")
    val question: String
)