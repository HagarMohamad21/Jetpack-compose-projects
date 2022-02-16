package com.example.jectpackcomposedemo.navigation

import java.lang.IllegalStateException

enum class MoviesScreens {
    HomeScreen,
    DetailsScreen;
    companion object{
       fun fromRoute(routeName:String?=null)= when(val route=routeName?.substringBefore("/")){
           HomeScreen.name ->HomeScreen
           DetailsScreen.name->DetailsScreen
           null->HomeScreen
           else ->throw IllegalStateException("Route $route is not recognized")
       }
    }
}