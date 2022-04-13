package com.example.jectpackcomposedemo.presentation.navigation



import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jectpackcomposedemo.presentation.navigation.ReaderScreens.CreateAccountScreen
import com.example.jectpackcomposedemo.presentation.navigation.ReaderScreens.LoginScreen
import com.example.jectpackcomposedemo.presentation.screens.details.BookDetailsScreen
import com.example.jectpackcomposedemo.presentation.screens.home.HomeScreen
import com.example.jectpackcomposedemo.presentation.screens.login.CreateAccountScreen
import com.example.jectpackcomposedemo.presentation.screens.login.LoginScreen
import com.example.jectpackcomposedemo.presentation.screens.search.SearchScreen
import com.example.jectpackcomposedemo.presentation.screens.splash.SplashScreen
import com.example.jectpackcomposedemo.presentation.screens.stats.BookStatsScreen
import com.example.jectpackcomposedemo.presentation.screens.update.BookUpdateScreen

@Composable
fun ReaderNavigation (){
    val navController= rememberNavController()
    val navHost= NavHost(navController = navController,
        startDestination =ReaderScreens.SplashScreen.name)
    {
      composable(ReaderScreens.SplashScreen.name){
         SplashScreen(navController)
      }
      composable(CreateAccountScreen.name){
          CreateAccountScreen(navController)
      }
        composable(LoginScreen.name){
          LoginScreen(navController)
        }

        composable(ReaderScreens.ReaderHomeScreen.name){
            HomeScreen(navController)
        }
        composable(ReaderScreens.DetailScreen.name){
            BookDetailsScreen(navController)
        }
        composable(ReaderScreens.ReaderStatsScreen.name){
            BookStatsScreen(navController)
        }
        composable(ReaderScreens.SearchScreen.name){
            SearchScreen(navController)
        }
        composable(ReaderScreens.UpdateScreen.name){
            BookUpdateScreen(navController = navController)
        }





    }
}