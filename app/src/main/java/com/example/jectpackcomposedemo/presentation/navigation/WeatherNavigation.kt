package com.example.jectpackcomposedemo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jectpackcomposedemo.presentation.navigation.WeatherScreens.SplashScreen
import com.example.jectpackcomposedemo.presentation.screens.SplashScreen

@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    val navHost= NavHost(navController = navController, startDestination = SplashScreen.name){

        composable(SplashScreen.name){
         SplashScreen(navController =navController )
        }

    }
}