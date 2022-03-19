package com.example.jectpackcomposedemo.di

import com.example.jectpackcomposedemo.data.repository.WeatherRepository
import com.example.jectpackcomposedemo.domain.repository.WeatherRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class ReposBinder {

    @Binds
    @Singleton
   abstract fun bindWeatherRepo(repository: WeatherRepoImpl):WeatherRepository


}