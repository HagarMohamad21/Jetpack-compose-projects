package com.example.jectpackcomposedemo.data.repository

import com.example.jectpackcomposedemo.data.api.model.Question
import com.example.jectpackcomposedemo.network.DataOrException

interface QuestionRepository {
    suspend fun getAllQuestion(): DataOrException<List<Question>, Boolean, Exception>
}