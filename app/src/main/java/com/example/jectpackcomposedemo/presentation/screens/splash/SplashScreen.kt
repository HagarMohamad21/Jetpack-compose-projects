package com.example.jectpackcomposedemo.presentation.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jectpackcomposedemo.R
import com.example.jectpackcomposedemo.presentation.navigation.WeatherScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){

    val scale= remember() {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true, block = {
        scale.animateTo(targetValue = .9f, animationSpec = tween(durationMillis = 800
            , easing ={ OvershootInterpolator(8f).getInterpolation(it)})
        )
     delay(1000L)
        navController.navigate(WeatherScreens.WeatherScreen.name)

    })

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally, modifier=Modifier.fillMaxSize()){
   Surface(modifier = Modifier
       .background(color = Color.White)
       .size(330.dp)
       .scale(scale.value)
       .border(
           width = 2.dp,
           color = Color.LightGray,
           shape = CircleShape
       )){
       Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
           Image(painter = painterResource(id = R.drawable.ic_sun),
               contentDescription ="Sun image",
               modifier = Modifier.size(95.dp), contentScale = ContentScale.Fit )
           Text(text = "Find the sun", style = MaterialTheme.typography.h5, color = Color.LightGray)
   }}
}}