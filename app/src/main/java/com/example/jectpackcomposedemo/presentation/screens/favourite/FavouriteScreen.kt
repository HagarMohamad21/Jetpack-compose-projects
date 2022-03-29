package com.example.jectpackcomposedemo.presentation.screens.favourite

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.jectpackcomposedemo.R
import com.example.jectpackcomposedemo.presentation.navigation.WeatherScreens
import com.example.jectpackcomposedemo.utils.formatDateDay
import com.example.jectpackcomposedemo.utils.formatTempDegree
import com.example.jectpackcomposedemo.utils.getImageUrl
import com.example.jectpackcomposedemo.widgets.WeatherTopBar

@Composable
fun FavouriteScreen(navController: NavController,viewModel:FavouriteViewModel){

    Scaffold(
        topBar = { WeatherTopBar(
            "Favourite",
            onNavigationClicked = {navController.popBackStack()}
        )}
    ) {
   

        Column(
            modifier=Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val list = viewModel.favouriteList.collectAsState().value
            if(list.isEmpty()){
                Text(text = "No Favourites")
            }
            else
            LazyColumn(content = {
                items(list) {
                    Log.e("TAG", "FavouriteScreen: SIZE::: ${list.size}", )
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(65.dp)
                            .padding(10.dp)
                            .border(
                                1.dp, color = Color(0xFFDAECEE), shape = CircleShape.copy(
                                    topStart = CornerSize(10.dp),
                                    bottomEnd = CornerSize(10.dp)
                                )
                            )
                            .background(
                                color = Color(0xFFDAECEE),

                                )
                            .clickable {
                                navController.navigate("${WeatherScreens.WeatherScreen.name}/${it.city}")
                            }) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(5.dp)

                        ) {

                            Text(
                               it.city,
                                style = TextStyle(
                                    color = Color.DarkGray,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Medium,
                                    fontStyle = FontStyle.Italic
                                )
                            )

                            Surface(
                                color = Color(0xFFD2D8FA),
                                modifier = Modifier.padding(4.dp)
                                , shape = CircleShape.copy(CornerSize(20.dp))
                            )
                            {
                                Text(text = it.country, color = Color.Black, modifier = Modifier.padding(3.dp))
                            }
                            IconButton(
                                modifier = Modifier.size(35.dp),
                                onClick = {
                                    viewModel.removeCity(it)
                                })
                            {
                                Icon(imageVector = Icons.Default.Delete, contentDescription = "", tint = Color(
                                    0xFFEE9A9A
                                )
                                )
                            }
                        }

                    }

                }
            })

        }
    }

}

