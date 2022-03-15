package com.example.jectpackcomposedemo.presentation.screens.question

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jectpackcomposedemo.components.*
import com.example.jectpackcomposedemo.ui.AppColors

@Preview
@Composable
fun QuestionScreen(viewModel: QuestionViewModel= hiltViewModel()){

    val questions= viewModel._data.value.data?.toMutableList()

    val loading=viewModel._data.value.loading
    val pathEffect=PathEffect.dashPathEffect(floatArrayOf(10f,10f),0f)
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), color = AppColors.mDarkPurple
    ) {
       Column(horizontalAlignment = Alignment.Start,
           verticalArrangement = Arrangement.Top, modifier = Modifier.padding(top=30.dp, start = 20.dp, end = 20.dp)) {
           loading?.let {
               if(it) CircularProgressIndicator(modifier =
               Modifier
                   .background(Color.Transparent)
                   .width(50.dp)
                   .height(50.dp)
                   .align(alignment = CenterHorizontally), color = AppColors.mOffWhite)
           }
           val counter= remember {
               mutableStateOf<Int>(0)
           }
           if (questions != null) {
               QuestionTracker(counter = counter.value,questions.size)

               Spacer(modifier = Modifier.height(10.dp))

               ShowProgress(counter.value)

               DashLine(pathEffect = pathEffect)

               Spacer(modifier = Modifier.height(20.dp))

                   val question=remember(){
                       mutableStateOf(questions.random())
                   }
                   QuestionRow(question.value)
                   ChoicesRow(question.value) {
                       counter.value++
                       question.value = questions.random()
                   }
           }


       }
    }


}