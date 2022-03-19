package com.example.jectpackcomposedemo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jectpackcomposedemo.presentation.navigation.WeatherScreens.*
import com.example.jectpackcomposedemo.presentation.screens.SplashScreen
import com.example.jectpackcomposedemo.presentation.screens.WeatherScreen
import com.example.jectpackcomposedemo.presentation.screens.main.WeatherViewModel

@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    val navHost= NavHost(navController = navController, startDestination = SplashScreen.name){

        composable(SplashScreen.name){
         SplashScreen(navController =navController )
        }
        composable(WeatherScreen.name){
            val viewModel= hiltViewModel<WeatherViewModel>()
         WeatherScreen(navController =navController ,viewModel=viewModel)
        }

    }
}