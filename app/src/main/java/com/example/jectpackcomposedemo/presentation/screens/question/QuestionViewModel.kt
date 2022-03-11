package com.example.jectpackcomposedemo.presentation.screens.question


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jectpackcomposedemo.data.api.model.Question
import com.example.jectpackcomposedemo.domain.usecase.GetQuestionsUseCase
import com.example.jectpackcomposedemo.network.DataOrException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(private val useCase: GetQuestionsUseCase):ViewModel() {

      val _data= mutableStateOf(
        DataOrException<List<Question>,Boolean,Exception>()
    )


    init {
       getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch {
            _data.value.loading=true
            _data.value=useCase.invoke()
            _data.value.loading=_data.value.data?.isEmpty()
        }
    }
}