package com.example.jectpackcomposedemo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.jectpackcomposedemo.model.getMovies
import com.example.jectpackcomposedemo.widget.MovieRow

@Composable
fun DetailsScreen(navController: NavController,movieId:String?){
   Surface (modifier = Modifier
       .fillMaxWidth()

   )
   {
      Column() {
          var item= getMovies().filter { it.id==movieId }
          Row(modifier = Modifier
              .fillMaxWidth()
         )
              {
              Icon(imageVector = Icons.Default.ArrowBack , tint = Color.Black, modifier = Modifier
                  .size(50.dp)
                  .padding(10.dp)
                  .clickable {
                      navController.popBackStack()
                  }, contentDescription ="Arrow back" )
          }
          Row(verticalAlignment = Alignment.Top,
              horizontalArrangement = Arrangement.Center) {

              MovieRow(movie =item[0] )
          }

          LazyRow{
              items(items = item[0].images){
                   image->
                  Card(modifier = Modifier.padding(10.dp).size(200.dp), elevation = 4.dp) {
                      Image(
                          painter = rememberImagePainter(data = image
                          , builder = {
                              crossfade(true)
                          }), contentDescription = "Image Poster", modifier = Modifier.fillMaxWidth().fillMaxHeight())
                  }
              }
          }
      }
   }
}