package com.example.jectpackcomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jectpackcomposedemo.presentation.navigation.ReaderNavigation
import com.example.jectpackcomposedemo.ui.theme.JectPackComposeDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.padding(12.dp)
            )
            {
               Content {
                   ReaderNavigation()
               }
            }

        }

//        val db= FirebaseFirestore.getInstance()
//        val user:MutableMap<String,Any> =HashMap()
//        user["first"]="Hagar"
//        user["second"]="Muhammad"
//
//        db.collection("users").
//                add(user)
//            .addOnSuccessListener {
//                Log.e("TAG", "onCreate: ${it.id}" )
//            }

    }
}


@Composable
fun Content(container: @Composable () -> Unit) {
    JectPackComposeDemoTheme {
        // A surface container using the 'background' color from the theme
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(all = 10.dp), color = MaterialTheme.colors.background) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            container()
        }
    }
    }
}



