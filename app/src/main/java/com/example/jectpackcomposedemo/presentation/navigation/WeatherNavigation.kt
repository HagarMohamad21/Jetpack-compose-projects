package com.example.jectpackcomposedemo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jectpackcomposedemo.presentation.navigation.WeatherScreens.*
import com.example.jectpackcomposedemo.presentation.screens.SplashScreen
import com.example.jectpackcomposedemo.presentation.screens.WeatherScreen
import com.example.jectpackcomposedemo.presentation.screens.about.AboutScreen
import com.example.jectpackcomposedemo.presentation.screens.favourite.FavouriteScreen
import com.example.jectpackcomposedemo.presentation.screens.favourite.FavouriteViewModel
import com.example.jectpackcomposedemo.presentation.screens.main.WeatherViewModel
import com.example.jectpackcomposedemo.presentation.screens.search.SearchScreen
import com.example.jectpackcomposedemo.presentation.screens.settings.SettingsScreen

@ExperimentalComposeUiApi
@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    val navHost = NavHost(navController = navController, startDestination = SplashScreen.name)
    {
        composable(SplashScreen.name) {
            SplashScreen(navController = navController)
        }

        val weatherRoute = WeatherScreen.name
        composable("$weatherRoute/{city}") { backStackEntry ->
            val viewModel = hiltViewModel<WeatherViewModel>()
            WeatherScreen(
                navController = navController,
                viewModel = viewModel,
                backStackEntry.arguments?.getString("city")!!
            )
        }
        composable(SearchScreen.name) {

            SearchScreen(navController = navController)
        }

        composable(AboutScreen.name){
           AboutScreen(navController = navController)
        }


        composable(FavouriteScreen.name){
            val viewModel = hiltViewModel<FavouriteViewModel>()
           FavouriteScreen(
                navController = navController,viewModel
            )
        }
        composable(SettingsScreen.name){
           SettingsScreen(
                navController = navController
            )
        }

    }

}