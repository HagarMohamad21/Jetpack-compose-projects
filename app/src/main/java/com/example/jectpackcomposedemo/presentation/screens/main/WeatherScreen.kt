package com.example.jectpackcomposedemo.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jectpackcomposedemo.data.model.WeatherApiResponse
import com.example.jectpackcomposedemo.presentation.navigation.WeatherScreens
import com.example.jectpackcomposedemo.presentation.screens.main.WeatherViewModel
import com.example.jectpackcomposedemo.utils.DataOrException
import com.example.jectpackcomposedemo.utils.formatDate
import com.example.jectpackcomposedemo.widgets.*

@Composable
fun WeatherScreen(
    navController: NavController,
    viewModel: WeatherViewModel,
    cityName: String = "Cairo"
) {
    //TODO Code this part in a neater way and use flow
    val result =
        produceState<DataOrException<WeatherApiResponse, Boolean, Exception>>(
            initialValue =
            DataOrException(loading = true)
        ) {
            value = viewModel.loadWeather(cityName)
        }

    Surface(modifier = Modifier.fillMaxSize()) {
        if (result.value.loading == true) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
            }
        } else if (result.value.data != null) {
            MainScaffold(navController, result.value.data)
        }
        else if(result.value.e!=null){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "${result.value.e?.message}", color = Color.Red)
            }

        }
    }
}

@Composable
fun MainScaffold(
    navController: NavController,
    weatherResponse: WeatherApiResponse?
) {


    weatherResponse?.let {
        val weatherItem = weatherResponse.list[0]
        Scaffold(topBar = {
            WeatherTopBar(
                title = "${weatherResponse.city.name},${weatherResponse.city.country}",
                isHomeScreen = true,
                onSearchClicked = { navController.navigate(WeatherScreens.SearchScreen.name) },
                navController = navController,
                cityDetails=weatherResponse
            )
        }) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(3.dp)
                    .fillMaxSize()
            )
            {
                Text(text = formatDate(weatherItem.dt), style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.height(10.dp))
                CircleWithColumn(
                    Color(0xFFFFC400),
                    200.dp,
                    weatherResponse
                )
                WeatherDescriptionBar(weatherItem)
                SunRiseAndSet(weatherItem)

                Text(
                    "This Week", style = TextStyle(
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                )
                WeekWeatherList(weatherResponse.list)
            }
        }


    }


}
