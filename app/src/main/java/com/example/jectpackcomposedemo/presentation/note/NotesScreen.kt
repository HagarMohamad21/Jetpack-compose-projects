package com.example.jectpackcomposedemo.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jectpackcomposedemo.domain.model.Note
import com.example.jectpackcomposedemo.navigation.NoteScreens
import com.example.jectpackcomposedemo.widgets.CustomButton
import com.example.jectpackcomposedemo.widgets.CustomEditText
import com.example.jectpackcomposedemo.widgets.NoteRow
import com.example.jectpackcomposedemo.widgets.TopBar
import com.example.jectpackcomposedemo.utils.navigate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteScreen(notes:List<Note> = emptyList(), onAddNote:(Note)->Unit={},
               onRemoveNote:(Note)->Unit={},navController: NavController){
    Column(modifier = Modifier.padding(6.dp)) {
        TopBar()
        MainContent(notes,onAddNote,onRemoveNote){
            navController.navigate(NoteScreens.NoteDetailsScreen.name,"noteDetails" to it)

        }
    }

}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainContent(notes: List<Note>,onAddNote: (Note) -> Unit,onRemoveNote: (Note) -> Unit,onNoteClicked:(Note)->Unit) {
    var title by remember() {
        mutableStateOf("")
    }
    var descritpion by remember() {
        mutableStateOf("")
    }

    var error by remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp),

        horizontalAlignment = Alignment.CenterHorizontally) {

      CustomEditText(onTextChanged = {
          if (it.all { char ->
                  char.isLetter() || char.isWhitespace()
              }) title = it
          error = !(descritpion.isNotEmpty()&&title.isNotEmpty())
      }, label = "Title", text = title)

        CustomEditText(maxLines = 40,
            onTextChanged = {
                descritpion = it
                error = !(descritpion.isNotEmpty()&&title.isNotEmpty())
      }, label = "Description", text = descritpion)

        AnimatedVisibility(visible = error) {
            Text(modifier = Modifier.padding(top = 10.dp),text = "Please fill in all fields", color = Color.Red, fontSize = 13.sp)
        }
        CustomButton(
            modifier = Modifier.padding(top = 10.dp),
            onClick =
            {
                    if(descritpion.isNotEmpty()&&title.isNotEmpty()){
                        onAddNote(Note(title=title, description = descritpion))
                        error=false
                        descritpion=""
                        title=""



                    }
                else {
                    error=true

                }
            }
            , text = "Save")

        Divider(modifier = Modifier.width(2.dp))


        LazyColumn() {
           items(notes){note->
               NoteRow(note =note , onNoteClicked = onNoteClicked)
            }
        }

    }

    }



