package com.example.jectpackcomposedemo.presentation.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jectpackcomposedemo.utils.Constants
import com.example.jectpackcomposedemo.utils.Constants.unitsList
import com.example.jectpackcomposedemo.widgets.WeatherTopBar




@Composable
fun SettingsScreen(navController: NavController,viewModel: SettingsViewModel){
    val expanded = remember {
        mutableStateOf(true)
    }

    val unit by viewModel.getUnitFromDataStore().collectAsState(initial = Constants.IMPERIAL)

//    if(isToastShown.value){
//        ShowToast(message = "Data has been saved")
//    }
    Scaffold(
        topBar = { WeatherTopBar(
            "Settings",
            onNavigationClicked = {navController.popBackStack()}
        ) }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {
                Text(modifier=Modifier.padding(10.dp),
                    text="Change weather unit:" , style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ) )

                Text(modifier=Modifier.padding(10.dp),
                    text= unit, style = TextStyle(
                        color = Color.Gray,
                        fontWeight = FontWeight.Light,
                        fontSize = 17.sp
                    ) )
            }

            DropdownMenu(expanded = expanded.value, onDismissRequest = {  
                expanded.value=false
            })
            {
                unitsList.forEachIndexed{
                    index, unit ->  
                DropdownMenuItem(onClick = {
                    expanded.value=false
                    viewModel.savePref(unit).run {
                    }
                    //save unit to data store
                })
                { Text(text = unit) } }
            }
//         Button(onClick = {
//             //viewModel save unit
//
//         }
//         , modifier = Modifier.padding(3.dp)){
//             Text(text = "Save")
//         }
        }
    }

}
