package com.example.jectpackcomposedemo.presentation.note

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jectpackcomposedemo.domain.model.Note
import com.example.jectpackcomposedemo.domain.usecase.NoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NoteViewModel  @Inject constructor(private val useCase: NoteUseCase):ViewModel() {

    val _noteList= MutableStateFlow<List<Note>>(emptyList())
    val noteList=_noteList.asStateFlow()


    init {
        viewModelScope.launch {
           useCase.getAllNotes().distinctUntilChanged().collect { notes->
               if(notes.isNullOrEmpty())
                   Log.e("TAG", ": empty!" )
               else
                   _noteList.value=notes
           }
        }
    }

    fun addNote(note: Note) = viewModelScope.launch { useCase.addNote(note) }
    fun updateNote(note: Note) = viewModelScope.launch { useCase.updateNote(note) }
    fun deleteNote(note: Note) = viewModelScope.launch { useCase.deleteNote(note) }
}