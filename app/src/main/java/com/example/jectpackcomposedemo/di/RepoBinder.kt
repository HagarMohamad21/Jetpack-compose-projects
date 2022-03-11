package com.example.jectpackcomposedemo.di

import com.example.jectpackcomposedemo.data.repository.QuestionRepository
import com.example.jectpackcomposedemo.domain.repository.QuestionRepositoryImpl
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
    abstract fun bindQuestionRepo(impl :QuestionRepositoryImpl):QuestionRepository
}