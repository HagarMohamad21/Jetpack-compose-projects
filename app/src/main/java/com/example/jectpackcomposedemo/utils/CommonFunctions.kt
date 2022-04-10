package com.example.jectpackcomposedemo.utils


import android.util.Log
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun ShowToast(message:String){
    val context= LocalContext.current
    Log.e("TAG", "ShowToast: ", )
    Snackbar() {
        Text(text = message)
    }

}