package com.example.jectpackcomposedemo.presentation.screens.favourite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jectpackcomposedemo.R
import com.example.jectpackcomposedemo.widgets.WeatherTopBar

@Composable
fun FavouriteScreen(navController: NavController,viewModel:FavouriteViewModel){

    Scaffold(
        topBar = { WeatherTopBar("Favourite", onNavigationClicked = {navController.popBackStack()})}
    ) {
        Column(
            modifier=Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            Text(stringResource(id = R.string.fav) , style = TextStyle(
//                color = Color.Black,
//                fontWeight = FontWeight.Bold,
//                fontSize = 20.sp
//            ) )

            LazyColumn(content = {
//               items(viewModel.favouriteList.value){
//                   Row() {
//                       Text(text = it.city)
//                   }
//               }
            })

        }
    }

}

