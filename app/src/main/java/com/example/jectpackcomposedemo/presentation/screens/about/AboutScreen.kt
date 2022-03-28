package com.example.jectpackcomposedemo.presentation.screens.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jectpackcomposedemo.R
import com.example.jectpackcomposedemo.widgets.WeatherTopBar

@Composable
fun AboutScreen(navController: NavController){

    Scaffold(
        topBar = { WeatherTopBar("About", onNavigationClicked = {navController.popBackStack()})}
    ) {
      Column(
          modifier=Modifier.fillMaxSize(),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
      ) {
//            Text(stringResource(id = R.string.about) , style = TextStyle(
//                color = Color.Black,
//                fontWeight = FontWeight.Bold,
//                fontSize = 20.sp
//            ) )
//          Text(stringResource(id = R.string.api) , style = TextStyle(
//                color = Color.Black,
//                fontWeight = FontWeight.Light,
//                fontSize = 16.sp
//            ) )
        }
    }

}