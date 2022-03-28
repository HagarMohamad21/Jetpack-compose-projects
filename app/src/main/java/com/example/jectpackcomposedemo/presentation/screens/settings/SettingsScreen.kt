package com.example.jectpackcomposedemo.presentation.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.example.jectpackcomposedemo.widgets.WeatherTopBar


@Composable
fun SettingsScreen(navController: NavController){

    Scaffold(
        topBar = { WeatherTopBar("Settings", onNavigationClicked = {navController.popBackStack()}) }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            Text(stringResource(id = R.string.fav) , style = TextStyle(
//                color = Color.Black,
//                fontWeight = FontWeight.Bold,
//                fontSize = 20.sp
//            ) )

        }
    }

}
