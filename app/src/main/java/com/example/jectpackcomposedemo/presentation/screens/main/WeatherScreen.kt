package com.example.jectpackcomposedemo.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.jectpackcomposedemo.data.model.WeatherApiResponse
import com.example.jectpackcomposedemo.presentation.screens.main.WeatherViewModel
import com.example.jectpackcomposedemo.utils.DataOrException
import com.example.jectpackcomposedemo.widgets.WeatherTopBar


@Composable
fun WeatherScreen(navController: NavController, viewModel: WeatherViewModel){
    //TODO Code this part in a neater way and use flow
    val result=
        produceState<DataOrException<WeatherApiResponse,Boolean,Exception>>(initialValue =
        DataOrException(loading = true)){
            value=viewModel.loadWeather("Seattle")
        }

Surface(modifier = Modifier.fillMaxSize()) {
      if (result.value.loading==true){
          Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
              CircularProgressIndicator()
          }
      }
      else if(result.value.data!=null){
          MainScaffold(navController,result.value.data)
      }
  }


}

@Composable
fun MainScaffold(
    navController: NavController,
    weather: WeatherApiResponse?
) {
    Scaffold(topBar = {WeatherTopBar(title = weather?.city?.name!!)}) {


    }
}
