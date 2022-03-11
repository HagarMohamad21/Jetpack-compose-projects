package com.example.jectpackcomposedemo.domain.repository

import com.example.jectpackcomposedemo.data.api.model.Question
import com.example.jectpackcomposedemo.data.api.service.QuestionService
import com.example.jectpackcomposedemo.data.repository.QuestionRepository
import com.example.jectpackcomposedemo.network.DataOrException
import javax.inject.Inject


class QuestionRepositoryImpl @Inject constructor(private val api:QuestionService):QuestionRepository {

    val dataOrException=DataOrException<List<Question>,Boolean,Exception>()

    override suspend fun getAllQuestion():DataOrException<List<Question>,Boolean,Exception>{
        try {
            dataOrException.loading=true
            dataOrException.data=api.getQuestion()
            dataOrException.loading=dataOrException.data?.isEmpty()
        }
        catch (e:Exception){
         dataOrException.error=e

        }
   return dataOrException }

}