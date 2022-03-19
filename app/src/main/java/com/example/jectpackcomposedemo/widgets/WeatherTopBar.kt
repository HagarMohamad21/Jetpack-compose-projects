package com.example.jectpackcomposedemo.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun WeatherTopBar(
    title:String="",
    elevation:Dp=2.dp,
    onButtonClicked:()->Unit={}

    
){
    TopAppBar(
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
    , elevation = elevation,
    ) {
        Text(text = title, fontSize = 17.sp, fontWeight = FontWeight.Bold)
    }
}