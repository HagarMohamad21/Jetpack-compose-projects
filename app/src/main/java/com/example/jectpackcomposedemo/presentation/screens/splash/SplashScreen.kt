package com.example.jectpackcomposedemo.presentation.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.jectpackcomposedemo.R
import com.example.jectpackcomposedemo.presentation.navigation.ReaderScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(painter = painterResource(id = R.drawable.ic_books_svgrepo_com) , contentDescription ="books" )
        LinearProgressIndicator()
        LaunchedEffect(key1 = Unit ){
            delay(2000L)
            navController.navigate(ReaderScreens.LoginScreen.name)
        }

    }
}