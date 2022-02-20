package com.example.jectpackcomposedemo.domain.repository

import com.example.jectpackcomposedemo.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun addNote(note: Note)
     fun getAllNotes(): Flow<List<Note>>
    suspend fun deleteAllNotes()
    suspend fun getNoteById(id:Long):Note
    suspend fun deleteNote(note:Note)
    suspend fun updateNote(note: Note)



}