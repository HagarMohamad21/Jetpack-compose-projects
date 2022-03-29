package com.example.jectpackcomposedemo.utils


import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun ShowToast(message:String){
    val context= LocalContext.current
    Log.e("TAG", "ShowToast: ", )
    Toast.makeText(context,message,Toast.LENGTH_SHORT).show()

}