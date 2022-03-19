package com.example.jectpackcomposedemo.di

import com.example.jectpackcomposedemo.data.api.WeatherService
import com.example.jectpackcomposedemo.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

@Provides
@Singleton
fun provideWeatherApiService()=Retrofit.Builder()
    .baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(WeatherService::class.java)

}
