package com.example.jectpackcomposedemo.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


val clickedModifier=Modifier.size(40.dp)

@Composable
fun RoundIconButton(
   modifier: Modifier=Modifier,
   imageVector:ImageVector,
   tint:Color= Color.Black.copy(alpha = 0.8f),
   onClick:()->Unit,
   backgroundColor: Color= MaterialTheme.colors.background,
   elevation: Dp =4.dp

){
    Card(modifier= Modifier
        .padding(all = 4.dp)
        .clickable {
            onClick.invoke()
        }
        .then(clickedModifier), shape = CircleShape
    , elevation = elevation,
    backgroundColor = backgroundColor) {
      Icon(imageVector = imageVector, contentDescription = "plus or minus icon", tint = tint)
    }
}