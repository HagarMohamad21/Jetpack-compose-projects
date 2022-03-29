package com.example.jectpackcomposedemo.presentation.screens.search

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import com.example.jectpackcomposedemo.presentation.navigation.WeatherScreens
import com.example.jectpackcomposedemo.widgets.TopSearchBar
import com.example.jectpackcomposedemo.widgets.WeatherTopBar


@ExperimentalComposeUiApi
@Composable
fun SearchScreen(navController: NavController){
    Scaffold(topBar ={ WeatherTopBar(
        "Search",
        onNavigationClicked = {navController.popBackStack()}
    )}) {

        TopSearchBar(placeHolder = "Cairo") {
            Log.e("TAG", "SearchScreen: $it" )
            navController.navigate("${WeatherScreens.WeatherScreen.name}/$it")

        }

    }


}