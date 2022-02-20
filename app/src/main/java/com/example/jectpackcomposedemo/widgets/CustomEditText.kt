package com.example.jectpackcomposedemo.widgets

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomEditText(
    modifier: Modifier=Modifier,
    maxLines:Int=1,
    onTextChanged:(String)->Unit,
    onImeAction:()->Unit={},
    label:String,
    text:String
){
    val keyboardController=LocalSoftwareKeyboardController.current
    TextField(value = text, colors = TextFieldDefaults.textFieldColors(
        backgroundColor = Color.Transparent
    ), maxLines = maxLines,
        label={ Text(text=label) },
    keyboardOptions = KeyboardOptions.Default.copy(imeAction=ImeAction.Done)
, keyboardActions = KeyboardActions(
            onDone = {
                onImeAction()
          keyboardController?.hide()
            },

), modifier =modifier,
        onValueChange =onTextChanged
    )
}

