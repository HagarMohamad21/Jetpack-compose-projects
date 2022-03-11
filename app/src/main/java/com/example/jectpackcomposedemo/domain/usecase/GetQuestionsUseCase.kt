package com.example.jectpackcomposedemo.domain.usecase

import com.example.jectpackcomposedemo.data.repository.QuestionRepository
import javax.inject.Inject

class GetQuestionsUseCase @Inject constructor(private val questionRepository: QuestionRepository){

    suspend operator fun invoke()=questionRepository.getAllQuestion()
}