package com.example.jectpackcomposedemo.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CustomInputField(
    modifier:Modifier=Modifier,
    isSingleLine:Boolean,
    valueState:MutableState<String>,
    labelId:String,
    enabled:Boolean,
    keyboardType: KeyboardType= KeyboardType.Number,
    imeAction: ImeAction=ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default)
{

    OutlinedTextField(value = valueState.value,
            onValueChange ={ valueState.value=it },
        textStyle = TextStyle(fontSize = 18.sp,
   color = MaterialTheme.colors.onBackground),
        singleLine = isSingleLine,
        modifier = Modifier.padding(all = 4.dp).fillMaxWidth(),
        keyboardOptions =
        KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction), enabled = enabled,
        leadingIcon = { Icon(imageVector = Icons.Rounded.AttachMoney, contentDescription = "Money Icon") },
        label = {
            Text(text = labelId)
        }
            , keyboardActions = onAction )

}