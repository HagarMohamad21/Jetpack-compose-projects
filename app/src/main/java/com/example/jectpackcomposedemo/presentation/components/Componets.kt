package com.example.jectpackcomposedemo.presentation.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun AppLogo (){
Text(text = "A.Reader", style = TextStyle(fontSize = 40.sp, color = Color.Black, fontWeight = FontWeight.Bold))
}

//@Composable
//fun Text