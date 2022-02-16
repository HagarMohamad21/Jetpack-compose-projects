package com.example.jectpackcomposedemo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jectpackcomposedemo.screens.DetailsScreen
import com.example.jectpackcomposedemo.screens.HomeScreen

@Composable
fun MovieNavigation(){
    val navController= rememberNavController()
    val navHost= NavHost(navController = navController, startDestination = MoviesScreens.HomeScreen.name ){
      composable(route = MoviesScreens.HomeScreen.name ){
      //here we pass where this should lead us
          HomeScreen(navController = navController) }
        composable(route = MoviesScreens.DetailsScreen.name+"/{movie}", arguments = listOf(
            navArgument(name = "movie"){type= NavType.StringType}) ){
            backStackEntry->
      //here we pass where this should lead us
          DetailsScreen(navController = navController,backStackEntry.arguments?.getString("movie"))
      }
    }

}
