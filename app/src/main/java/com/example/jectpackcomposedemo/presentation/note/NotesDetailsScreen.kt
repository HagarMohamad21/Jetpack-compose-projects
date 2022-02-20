package com.example.jectpackcomposedemo.presentation.note

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jectpackcomposedemo.domain.model.Note
import com.example.jectpackcomposedemo.widgets.NoteRow
import com.example.jectpackcomposedemo.widgets.TopBar


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteDetailsScreen(
    navController: NavController, note: Note?
){
    Column(modifier = Modifier.padding(6.dp)) {
        TopBar()
        Spacer(modifier = Modifier.height(50.dp))

note?.let {
    NoteRow(note = note)
}



    }

}