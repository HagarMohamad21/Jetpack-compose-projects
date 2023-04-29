package com.example.jectpackcomposedemo.presentation.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.jectpackcomposedemo.presentation.components.AppLogo
@OptIn(ExperimentalComposeUiApi::class)

@Composable
fun LoginScreen(navController: NavHostController) {
Surface(modifier = Modifier.fillMaxSize()) {
    Column(verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
        AppLogo()
    }
}


@Composable
fun UserForm() {
    val email = rememberSaveable() { mutableStateOf("") }
    val password = rememberSaveable() { mutableStateOf("") }
    val passwordVisibility = rememberSaveable() { mutableStateOf(false) }
    val focusRequest = FocusRequester.Default
    val keyboardState = LocalSoftwareKeyboardController.current
    val valid = rememberSaveable(email.value, password.value) {
        email.value.trim().isNotEmpty() && password.value.trim().isNotEmpty()
    }

    val modifier = Modifier
        .height(250.dp)
        .verticalScroll(rememberScrollState())

    Column(modifier) {

    }

}
}