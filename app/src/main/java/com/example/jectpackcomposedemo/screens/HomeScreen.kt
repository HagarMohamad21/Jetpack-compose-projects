package com.example.jectpackcomposedemo.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jectpackcomposedemo.model.Movie
import com.example.jectpackcomposedemo.model.getMovies
import com.example.jectpackcomposedemo.navigation.MoviesScreens
import com.example.jectpackcomposedemo.widget.MovieRow


@Composable
fun HomeScreen(navController: NavController){
    MainContent(){movie->
        navController.navigate(MoviesScreens.DetailsScreen.name+"/$movie")
    }
}

@Composable
fun MainContent(moviesList:List<Movie> = getMovies(),movieClicked:(String)->Unit={})
{
    Scaffold(
        topBar =
        { TopAppBar(title = {
            Text("Movies App", color = Color.White,
                fontWeight = FontWeight.Bold)
        }
            ,modifier = Modifier.height(50.dp),
            backgroundColor= Color.Red) },
    ) {
        Column() {
            LazyColumn(){
                items(items = moviesList){
                        movieItem->
                    MovieRow(movieItem){
                        movieClicked(it)
                    }
                }
            }
        }
    }
}

