package com.example.jectpackcomposedemo.di

import com.example.jectpackcomposedemo.data.api.ApiConstants.BASE_URL
import com.example.jectpackcomposedemo.data.api.service.QuestionService
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
    fun provideRetrofit()=Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun providesQuestionService(retrofit: Retrofit)=retrofit.create(QuestionService::class.java)


}