package com.example.jectpackcomposedemo.components

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Start
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
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
fun ChoicesRow(question: Question,onNextClicked:()->Unit) {

    val choices = remember(question) {
        question.choices.toMutableList()
    }

    val correctAnswer = question.answer

  val currentAnswerCorrect= remember (question){
      mutableStateOf<Boolean?>(false)
  }
    val isSelected= remember {
      mutableStateOf(false)
  }
    val clickedIndex= remember {
        mutableStateOf<Int?>(null)
    }
 val errorMessageVisible= remember {
        mutableStateOf<Boolean>(false)
    }

val radioButtonEnabled= remember {
        mutableStateOf<Boolean>(true)
    }


    val updateAnswer:(Int) ->Unit = remember (question){
        {
          clickedIndex.value=it
          currentAnswerCorrect.value=choices[it]==question.answer
        }
    }

    Log.e("TAG", "ChoicesRow: ======correctAnswer=== ${correctAnswer}" )
     Log.e("TAG", "ChoicesRow: ======isSelected=== ${isSelected.value}" )


    Column() {
        choices.forEachIndexed { index, choice ->
            
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
                    radioButtonEnabled.value=false
                }, modifier = Modifier.padding(3.dp),
                    colors = RadioButtonDefaults.colors(
                        disabledColor = if(choice==question.answer) {Color.Green
                        }
                        else Color.Red.copy(alpha = 0.5f)
                    ),
                           enabled = radioButtonEnabled.value
                )


                Spacer(modifier = Modifier.width(5.dp))
                Text(text = choice, color = AppColors.mOffWhite, fontSize = 14.sp)
            }
        }

        
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            modifier = Modifier
                .padding(5.dp)
                .align(alignment = Alignment.CenterHorizontally)
                .fillMaxWidth(0.5f)
                , shape = CircleShape.copy(all= CornerSize(15.dp))
            , colors = ButtonDefaults.buttonColors(
                contentColor = AppColors.mLightBlue
            ),
            onClick = {
                    errorMessageVisible.value=clickedIndex.value==null
                if(clickedIndex.value!=null)
                    onNextClicked.invoke()
                clickedIndex.value=null
                radioButtonEnabled.value=true
                 }
        ){
            Text(text = "Next", color = AppColors.mOffWhite, fontWeight = FontWeight.Bold,  fontSize = 17.sp
            , modifier = Modifier.padding(3.dp))
        }
        Spacer(modifier = Modifier.height(10.dp))
        AnimatedVisibility(visible = errorMessageVisible.value) {
            Text(text = "Please select an answer first",
                color = Color.Red, fontSize = 16.sp)
        }
        
    }

    }




@Composable
fun ShowProgress(progress:Int){

    val brushGrad=Brush.linearGradient(listOf(
        Color(0xFFF95075)
    ,  Color(0xFFBE6BE5)
    ))

    val score = remember(progress){
        mutableStateOf(progress*.005f)
    }

   Row(
   modifier = Modifier
       .fillMaxWidth()
       .padding(3.dp)
       .height(45.dp)
       .background(Color.Transparent)
       .border(
           brush = Brush.linearGradient
               (colors = listOf(AppColors.mLightPurple, AppColors.mLightPurple)), width = 2.dp,
           shape = RoundedCornerShape(34.dp)
       )
       .clip(
           RoundedCornerShape(
               topEndPercent = 50,
               bottomStartPercent = 50,
               topStartPercent = 50,
               bottomEndPercent = 50
           )
       )
       , verticalAlignment = Alignment.CenterVertically
   )

   {
       if(progress>3)
       Button(onClick = { }, contentPadding = PaddingValues(1.dp), modifier = Modifier
           .fillMaxWidth(score.value)
           .background(brushGrad),
           elevation = null,
           enabled = false
           ,
           colors = buttonColors(
           backgroundColor = Color.Transparent,
           disabledBackgroundColor = Color.Transparent
           )) {

       }
   }
}
