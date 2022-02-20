package com.example.jectpackcomposedemo.widgets

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomButton(
    onClick:()->Unit,
    text:String,
    modifier: Modifier=Modifier,
    enabled:Boolean=true
){

    Button(onClick = onClick
        , enabled = enabled,
    shape = CircleShape,
    modifier = modifier) {
        Text(text = text)
    }


}