package com.example.jectpackcomposedemo.components

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Start
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jectpackcomposedemo.data.api.model.Question
import com.example.jectpackcomposedemo.ui.AppColors

@Preview
@Composable
fun QuestionTracker( counter:Int=1,outOf:Int=100){

    Text(text = buildAnnotatedString {
        withStyle(SpanStyle(color = AppColors.mLightGray, fontSize = 27.sp,fontWeight = FontWeight.Bold)){
            append("Question $counter/")
        }
        withStyle(SpanStyle(color = AppColors.mLightGray, fontSize = 14.sp, fontWeight = FontWeight.Light)){
            append("$outOf")
        }
    })
}

@Composable
fun DashLine(pathEffect: PathEffect){
    Canvas(modifier = Modifier
        .padding(top = 20.dp)
        .height(1.dp)
        .fillMaxWidth()){
        drawLine(color = AppColors.mLightGray, start = Offset(0f,0f), end = Offset(size.width,0f), pathEffect = pathEffect)
    }
}

@Composable
fun QuestionRow(question:Question){
    Text(
        text = question.question,
        color = AppColors.mOffWhite,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f)
            .padding(3.dp),
        lineHeight = 22.sp
    )
}

@Composable
fun ChoicesRow(question: Question) {

    val choices = remember(question) {
        question.choices.toMutableList()
    }

    val correctAnswer = question.answer

  val currentAnswerCorrect= remember (question){
      mutableStateOf<Boolean?>(null)
  }
    val isSelected= remember {
      mutableStateOf(false)
  }
    val clickedIndex= remember {
        mutableStateOf<Int?>(null)
    }


    val updateAnswer:(Int) ->Unit = remember (question){
        {
          clickedIndex.value=it
          currentAnswerCorrect.value=choices[it]==question.answer
        }
    }

    Log.e("TAG", "ChoicesRow: ======correctAnswer=== ${correctAnswer}" )
     Log.e("TAG", "ChoicesRow: ======isSelected=== ${isSelected.value}" )


    choices.forEachIndexed { index, choice ->
        var  correctAnswerIndex=-1
        if (choice == correctAnswer)
          correctAnswerIndex = index

        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier
                .background(Color.Transparent)
                .fillMaxWidth()
                .height(50.dp)
                .border(
                    width = 4.dp,
                    color = AppColors.mOffDarkPurple,
                    shape = RoundedCornerShape(15.dp)
                )
                .clip(
                    RoundedCornerShape(
                        topStartPercent = 50,
                        bottomEndPercent = 50,
                        bottomStartPercent = 50,
                        topEndPercent = 50
                    )
                )
                .padding(4.dp),
            verticalAlignment = CenterVertically, horizontalArrangement = Start

        ){
            RadioButton(selected = clickedIndex.value==index, onClick = {
            Log.e("TAG", "ChoicesRow -----------clickedIndex: $index", )
               updateAnswer(index)
        }, modifier = Modifier.padding(3.dp),

        colors = RadioButtonDefaults.colors(
            selectedColor = if(currentAnswerCorrect.value==true) Color.White
                            else Color.Red.copy(alpha = 0.5f)
        ))


            Spacer(modifier = Modifier.width(5.dp))
            Text(text = choice, color = AppColors.mOffWhite, fontSize = 14.sp)
        }
    }



    }


