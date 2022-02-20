package com.example.jectpackcomposedemo.widgets

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jectpackcomposedemo.domain.model.Note
import com.example.jectpackcomposedemo.utils.formatDate
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteRow(note: Note, onNoteClicked:(Note)->Unit={}){

    Surface(modifier = Modifier
        .clip(
            CircleShape.copy(
                bottomEnd = CornerSize(10.dp), topStart = CornerSize(10.dp)
            )
        ).padding(5.dp)
        .fillMaxWidth(), color = Color(0xfffeeeaaa)
    ) {

        Column(modifier = Modifier.clickable {
            onNoteClicked(note)
        }.padding(top=8.dp, bottom = 8.dp,start=15.dp, end = 15.dp))
        {
            Text(text = note.title, fontWeight = FontWeight.ExtraBold, fontSize = 17.sp, color = Color.Black, style = MaterialTheme.typography.subtitle2, modifier = Modifier.padding(2.dp))
            Text(text =note.description, fontWeight = FontWeight.Light, fontSize = 14.sp, color = Color.DarkGray, style = MaterialTheme.typography.subtitle1, modifier = Modifier.padding(2.dp))
            Text(text =
                    formatDate(note.creationDate.time)
                ,
                fontWeight = FontWeight.Bold, fontSize = 13.sp, color = Color.Gray, style = MaterialTheme.typography.caption, modifier = Modifier.padding(2.dp))

        }
    }

}