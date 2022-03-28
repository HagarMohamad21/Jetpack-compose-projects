package com.example.jectpackcomposedemo.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@ExperimentalComposeUiApi
@Composable
fun TopSearchBar(placeHolder: String,onSearch:(String)->Unit){
    val queryState= rememberSaveable{
        mutableStateOf("")
    }
    val keyboardController=LocalSoftwareKeyboardController.current
    val validInput= remember(queryState.value) { queryState.value.trim().isNotEmpty() }

    CustomEditText(placeHolder,queryState
        , onAction = KeyboardActions
        {
        if(!validInput) return@KeyboardActions
        else {
            onSearch(queryState.value.trim())
            queryState.value = ""
            keyboardController?.hide()
        }
    }
    )
}

@Composable
fun CustomEditText(
    placeHolder:String="",
    valueState:MutableState<String>,
    keyboardType: KeyboardType= KeyboardType.Text,
    imeAction: ImeAction= ImeAction.Next,
    onAction:KeyboardActions= KeyboardActions.Default
    )
{
    
    OutlinedTextField(
        value = valueState.value ,
        onValueChange = {valueState.value=it},
        label = {Text(text=placeHolder)},
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction)
        , keyboardActions = onAction,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.DarkGray,
            cursorColor = Color.Black,
        ),
        shape = RoundedCornerShape(15.dp),
        singleLine = true,
        maxLines = 1
    ,   modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        textStyle = TextStyle(color = Color.DarkGray)
    )


}