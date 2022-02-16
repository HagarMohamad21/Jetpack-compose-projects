package com.example.jectpackcomposedemo.widget

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.jectpackcomposedemo.model.Movie

@Composable
fun MovieRow(movie:Movie,onClickMovieItem:(String) -> Unit={})
{
    val expanded = remember{
        mutableStateOf(false)
    }
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(corner = CornerSize(13.dp)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                onClickMovieItem(movie.id)
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Surface(
                modifier = Modifier.size(100.dp)
            ) {
                Image(painter = rememberImagePainter(data = movie.images[0]
                    , builder = {
                    crossfade(true)
                    transformations(CircleCropTransformation())
                }), contentDescription = "Image Poster")
            }
            Spacer(modifier = Modifier.width(15.dp))
            Column(
                Modifier.padding(4.dp)
            ) {
                 Text(movie.title,style = MaterialTheme.typography.h6)
                Text(buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Gray)){
                        append("Rating: ")
                    }
                    withStyle(style = SpanStyle(color = Color(0xfffFFD700), fontWeight = FontWeight.SemiBold)){
                        append(movie.rating)
                    }

                })
                 Text("Director: ${movie.director}",style = MaterialTheme.typography.caption)


                       Icon(
                           modifier = Modifier.padding(5.dp)
                               .size(30.dp)
                               .clickable {
                                   expanded.value=!expanded.value
                               },
                    tint = Color.Blue,
                    imageVector =
                if(expanded.value)
                    Icons.Default.KeyboardArrowUp
                else
                    Icons.Default.KeyboardArrowDown ,
                    contentDescription ="Expanding arrow"
                )


                AnimatedVisibility(visible = expanded.value) {
                    Column() {
                        Text( buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.Black,
                               )
                            ) {
                                append("Plot: ")
                            }
                            withStyle(style = SpanStyle(color = Color.DarkGray,
                                fontWeight = FontWeight.Light)) {
                                append(movie.plot)
                            }

                        }, modifier = Modifier.padding(6.dp))

                        Divider(modifier = Modifier.padding(3.dp))
                        Text("Genre: ${movie.genre}")
                        Text("Released: ${movie.year}")

Text("Actors: ${movie.actors}")




                    }
                }
                
                
            }
           
        }
    }
}