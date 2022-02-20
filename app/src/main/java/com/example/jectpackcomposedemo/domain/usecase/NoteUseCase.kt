package com.example.jectpackcomposedemo.domain.usecase

import com.example.jectpackcomposedemo.domain.model.Note
import com.example.jectpackcomposedemo.domain.repository.NoteRepository
import javax.inject.Inject

class NoteUseCase @Inject constructor(private val repository: NoteRepository) {

    suspend fun addNote(note: Note) = repository.addNote(note)
    suspend fun updateNote(note: Note) = repository.updateNote(note)
    suspend fun deleteNote(note: Note) = repository.deleteNote(note)
     fun getAllNotes() = repository.getAllNotes()
    suspend fun getNoteById(id: Long) = repository.getNoteById(id)
    suspend fun deleteAllNotes() = repository.deleteAllNotes()



}