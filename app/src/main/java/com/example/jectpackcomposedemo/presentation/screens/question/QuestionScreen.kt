package com.example.jectpackcomposedemo.presentation.screens.question

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jectpackcomposedemo.components.ChoicesRow
import com.example.jectpackcomposedemo.components.DashLine
import com.example.jectpackcomposedemo.components.QuestionRow
import com.example.jectpackcomposedemo.components.QuestionTracker
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
        loading?.let {
            if(it) CircularProgressIndicator(modifier = Modifier.background(color = AppColors.mOffWhite))
        }
       Column(horizontalAlignment = Alignment.Start,
           verticalArrangement = Arrangement.Top, modifier = Modifier.padding(top=30.dp, start = 20.dp, end = 20.dp)) {
           QuestionTracker()
           DashLine(pathEffect = pathEffect)
           Spacer(modifier = Modifier.height(20.dp))

           val let = questions?.let {
               val question=questions.random()
               QuestionRow(question)
               ChoicesRow(question)
           }

       }
    }


}