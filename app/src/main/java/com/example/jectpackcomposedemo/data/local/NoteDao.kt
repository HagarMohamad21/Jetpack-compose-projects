package com.example.jectpackcomposedemo.data.local

import androidx.room.*
import com.example.jectpackcomposedemo.domain.model.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDao {

    @Query("SELECT * from notes_table")
    fun getAllNotes(): Flow<List<Note>>

    @Query("DELETE from notes_table")
    suspend fun deleteAllNotes()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note:Note)

     @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note:Note)

    @Query("SELECT * from notes_table WHERE id=:noteId")
    suspend fun getNoteById(noteId:Long):Note

    @Delete
   suspend fun deleteNote(note:Note)




}