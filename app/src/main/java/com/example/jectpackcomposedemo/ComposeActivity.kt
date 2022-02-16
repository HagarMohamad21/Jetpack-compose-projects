package com.example.jectpackcomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.jectpackcomposedemo.navigation.MovieNavigation
import com.example.jectpackcomposedemo.ui.theme.JectPackComposeDemoTheme

class ComposeActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {MyApp{
            MovieNavigation()
        }

        }
    }


   // @Preview
    @Composable
    fun MyApp(container: @Composable () -> Unit = {}) {
        JectPackComposeDemoTheme {
            container()
        }
    }
}



