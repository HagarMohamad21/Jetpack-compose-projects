package com.example.jectpackcomposedemo.di

import com.example.jectpackcomposedemo.domain.repository.NoteRepository
import com.example.jectpackcomposedemo.data.repository.NoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoBinder {



    @Singleton
    @Binds
   abstract fun provideNoteRepository(noteRepositoryImpl: NoteRepositoryImpl): NoteRepository
}