package com.example.jectpackcomposedemo

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jectpackcomposedemo.domain.model.Note
import com.example.jectpackcomposedemo.navigation.NoteNavigation
import com.example.jectpackcomposedemo.presentation.NoteScreen
import com.example.jectpackcomposedemo.presentation.note.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@RequiresApi(Build.VERSION_CODES.O)
@AndroidEntryPoint
class ComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.padding(12.dp)
            ) {
                val noteViewModel by viewModels<NoteViewModel>()
                 NoteApp(noteViewModel)
            }

        }
    }

   @Composable
    private fun NoteApp(noteViewModel: NoteViewModel) {
       val notes = noteViewModel.noteList.collectAsState().value
       val onAddNote:(note: Note)->Unit= {noteViewModel.addNote(it)}
       val onRemoveNote:(note: Note)->Unit={noteViewModel.deleteNote(it)}

          NoteNavigation(onNoteAdded = onAddNote, onNoteRemoved = onRemoveNote, noteList =notes)
    }
}






