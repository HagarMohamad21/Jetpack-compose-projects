package com.example.jectpackcomposedemo.widgets


import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.jectpackcomposedemo.R
import com.example.jectpackcomposedemo.data.model.WeatherApiResponse
import com.example.jectpackcomposedemo.data.model.WeatherItem
import com.example.jectpackcomposedemo.presentation.navigation.WeatherScreens
import com.example.jectpackcomposedemo.utils.*

@Preview
@Composable
fun WeatherTopBar(
    title: String = "",
    elevation: Dp = 2.dp,
    isHomeScreen: Boolean = false,
    navIcon: Icon? = null,
    onSearchClicked: () -> Unit = {},
    onNavigationClicked:()-> Unit={},
    navController: NavController?=null


) {
    val dialogShown= remember {
        mutableStateOf(false)
    }

    if(dialogShown.value){

        ShowDropDownMenu(dialogShown = dialogShown, navController = navController)
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

            } else Box {}

        },

        navigationIcon = {
            if (!isHomeScreen) {
                IconButton(
                    onClick = {onNavigationClicked.invoke()}
                ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back arrow")
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
fun CircleWithColumn(
    backgroundColor: Color,
    size: Dp,
    weatherResponse: WeatherApiResponse
) {
    val weather = weatherResponse.list[0].weather[0]
    val weatherItem = weatherResponse.list[0]
    val degree = formatTempDegree(weatherItem.temp.day)
    val weatherDescription = weather.main
    val imageUrl = getImageUrl(weatherItem)
    Log.e("TAG", "MainScaffold: $imageUrl")


    Surface(
        modifier = Modifier.size(size), shape = CircleShape, color = backgroundColor
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = rememberImagePainter(imageUrl),
                contentDescription = "Image",
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = degree,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.ExtraBold
            )
            Text(text = weatherDescription, fontStyle = FontStyle.Italic)
        }
    }
}

@Composable
fun WeatherDescriptionBar(
    weatherItem: WeatherItem
) {
    val humidity: String = weatherItem.humidity.toString()
    val pressure: String = weatherItem.pressure.toString()
    val wind: String = weatherItem.speed.toString()

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(top = 5.dp),
        elevation = 2.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 2.dp, end = 2.dp)
        ) {

            IconWithText(
                iconDrawable = R.drawable.ic_raindrops,
                text = "$humidity%"
            )
            IconWithText(
                iconDrawable = R.drawable.ic_pressure,
                text = "$pressure psi",

                )
            IconWithText(iconDrawable = R.drawable.ic_windy, text = "$wind mph")

        }
    }

}

@Composable
fun SunRiseAndSet(weatherItem: WeatherItem) {

    val sunRise = formatDateTime(weatherItem.sunrise)
    val sunSet = formatDateTime(weatherItem.sunset)

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 2.dp, end = 2.dp, top = 10.dp)
            .fillMaxWidth()
    ) {

        IconWithText(iconDrawable = R.drawable.ic_sunrise, text = sunRise,)
        IconWithText(iconDrawable = R.drawable.ic_sunset, text = sunSet, )

    }
}

@Composable
fun IconWithText(
    iconDrawable: Int,
    text: String,
    isMenu: Boolean=false
) {
    Row(verticalAlignment = Alignment.CenterVertically)
    {
        Image(
            modifier = Modifier
                .size(30.dp)
                .padding(2.dp),
            painter = painterResource(id = iconDrawable), contentDescription = "",
        )
        Text(
            text = text,
            style = TextStyle(
                color = Color.DarkGray,
                fontSize = if(isMenu) 16.sp else 13.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}


@Composable
fun WeekWeatherList(list: List<WeatherItem>) {
    LazyColumn(content = {
        items(list) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
                    .padding(3.dp)
                    .border(
                        1.dp, color = Color.LightGray, shape = CircleShape.copy(
                            topStart = CornerSize(10.dp),
                            bottomEnd = CornerSize(10.dp)
                        )
                    ),

                ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(5.dp)
                ) {
                    Text(
                        formatDateDay(it.dt),
                        style = TextStyle(
                            color = Color.DarkGray,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            fontStyle = FontStyle.Italic
                        )
                    )

                    val imageUrl = getImageUrl(it)
                    Image(
                        painter = rememberImagePainter(imageUrl),
                        contentDescription = "Image",
                        modifier = Modifier.size(35.dp)
                    )

                    Surface(
                        color = Color(0xFFFFC400),
                        modifier = Modifier.padding(4.dp)
                        , shape = CircleShape.copy(CornerSize(20.dp))
                    )
                    {
                        Text(text = it.weather[0].main, color = Color.Black, modifier = Modifier.padding(3.dp))
                    }

                    Row(   modifier = Modifier.padding(4.dp)) {
                        Text(   modifier = Modifier.padding(2.dp),
                            text =  formatTempDegree(it.temp.max),
                            style = TextStyle(color = Color.Blue,
                                fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic, fontSize = 13.sp))
                        Text( modifier = Modifier.padding(2.dp),
                            text = formatTempDegree(it.temp.min),
                            style = TextStyle(color = Color.LightGray, fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Italic, fontSize = 13.sp))
                    }

                }

            }

        }
    })
}


@Composable
fun ShowDropDownMenu(dialogShown:MutableState<Boolean>,navController: NavController?=null){

    val menuItems= listOf("Favourite","Settings","About")
    val menuIcons= listOf(R.drawable.ic_favorite,
        R.drawable.ic_settings,
        R.drawable.ic_info)


    val expanded =remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopEnd)
            .absolutePadding(top = 45.dp, right = 24.dp)

    ) {

        DropdownMenu(modifier = Modifier.width(140.dp),expanded =expanded.value , onDismissRequest = {
            expanded.value=false
            dialogShown.value = false
        }) {
            menuItems.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    when(index){
                        0->{navController?.navigate(WeatherScreens.FavouriteScreen.name)}
                        1->{navController?.navigate(WeatherScreens.SettingsScreen.name)}
                        else ->navController?.navigate(WeatherScreens.AboutScreen.name)
                    }
                    expanded.value=false
                    dialogShown.value=false
                }) {
                    IconWithText(iconDrawable = menuIcons[index], text = menuItems[index],true)
                }
            }
        }
    }


}