package com.example.jectpackcomposedemo.data.repository

import com.example.jectpackcomposedemo.data.local.NoteDao
import com.example.jectpackcomposedemo.domain.model.Note
import com.example.jectpackcomposedemo.domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val noteDao: NoteDao) : NoteRepository {

    override suspend fun addNote(note: Note)=noteDao.addNote(note)

    override fun getAllNotes()=noteDao.getAllNotes().flowOn(Dispatchers.IO).conflate()

    override suspend fun deleteAllNotes()=noteDao.deleteAllNotes()

    override suspend fun getNoteById(id: Long)=noteDao.getNoteById(id)

    override suspend fun deleteNote(note: Note)=noteDao.deleteNote(note)


    override suspend fun updateNote(note: Note)=noteDao.updateNote(note)

}