package com.example.jectpackcomposedemo.data.local

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.jectpackcomposedemo.domain.model.Note
import com.example.jectpackcomposedemo.utils.DateTypeConverter

@RequiresApi(Build.VERSION_CODES.O)
@Database(exportSchema = false, version = 1, entities = [Note::class])
@TypeConverters(DateTypeConverter::class)
abstract class NotesDatabase :RoomDatabase(){

    abstract fun getNotesDao():NoteDao

}