package com.example.jectpackcomposedemo.data.api.service

import com.example.jectpackcomposedemo.data.api.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionService {

    @GET("world.json")
    suspend fun getQuestion():List<Question>
}