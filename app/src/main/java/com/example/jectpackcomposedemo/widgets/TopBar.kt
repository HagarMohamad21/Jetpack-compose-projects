package com.example.jectpackcomposedemo.widgets

import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.jectpackcomposedemo.R
import com.example.jectpackcomposedemo.data.model.WeatherApiResponse
import com.example.jectpackcomposedemo.domain.model.Favorite
import com.example.jectpackcomposedemo.presentation.screens.favourite.FavouriteViewModel
import com.example.jectpackcomposedemo.utils.ShowToast


@Preview
@Composable
fun WeatherTopBar(
    title: String = "",
    elevation: Dp = 2.dp,
    isHomeScreen: Boolean = false,
    navIcon: Icon? = null,
    onSearchClicked: () -> Unit = {},
    onNavigationClicked: () -> Unit = {},
    navController: NavController? = null,
    favouriteViewModel: FavouriteViewModel = hiltViewModel(),
    cityDetails: WeatherApiResponse?=null
)
{
    val dialogShown= remember {
        mutableStateOf(false)
    }

    val showToast= remember {
        mutableStateOf(false)
    }


    if(dialogShown.value){
        ShowDropDownMenu(dialogShown = dialogShown, navController = navController)
    }
     if(showToast.value){
      ShowToast( message ="Testttttttt")
     }



    TopAppBar(
        title = {
            Text(text = title, fontSize = 15.sp, fontWeight = FontWeight.Bold)
        },
        actions = {
            if (isHomeScreen) {
                IconButton(onClick = {onSearchClicked.invoke() }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        Modifier.padding(3.dp)
                    )
                }
                IconButton(onClick = {
                    dialogShown.value=true
                }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu",
                        Modifier.padding(3.dp)
                    )
                }

            }
            else Box {}


        },

        navigationIcon = {
            if (!isHomeScreen) {
                IconButton(
                    onClick = {onNavigationClicked.invoke()}
                ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back arrow")
                }
            }

            if(isHomeScreen){
                cityDetails?.let {
                    HandleFavourite(it,favouriteViewModel, showToast = showToast)
                }

            }
        },
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(5.dp),
        elevation = elevation,
    )
    Log.e("TAG", "WeatherTopBar dialog: ${dialogShown.value}", )

}

@Composable
fun HandleFavourite(cityDetails: WeatherApiResponse,favouriteViewModel: FavouriteViewModel,showToast: MutableState<Boolean>){
val favCity=Favorite(cityDetails.city.name,cityDetails.city.country)

val favCities=favouriteViewModel.favouriteList.collectAsState().value
    var isFav= remember(favCities) {
        favCities.contains(
            favCity
        )
    }

    val favDrawableId= remember(isFav) {
        if(isFav)mutableStateOf(R.drawable.ic_favorite_red)
        else mutableStateOf(R.drawable.ic_favorite)
    }

    val message= remember(isFav) {
        if (isFav) mutableStateOf("Added to Favorites")
        else mutableStateOf("Removed from Favorites")

    }
    Log.e("TAG", "HandleFavourite: ${message.value}", )





    IconButton(onClick = {
           if(isFav)
           {
               favouriteViewModel.removeCity(favCity).run {
                   isFav=false

               }
           }
        else
            favouriteViewModel.addCityToFavs(favCity).run {
               isFav=true
           }

    }) {
        Image(painter = painterResource(id = favDrawableId.value), contentDescription ="" )
    }
}