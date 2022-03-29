package com.example.jectpackcomposedemo.di


import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Room
import com.example.jectpackcomposedemo.data.api.WeatherService
import com.example.jectpackcomposedemo.data.database.FavouriteDB
import com.example.jectpackcomposedemo.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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



    @Singleton
    @Provides
    fun provideNotesDao(favouriteDB:FavouriteDB)=favouriteDB.getDao()


    @Singleton
    @Provides
    fun provideNotesDB(@ApplicationContext context: Context)=
        Room.databaseBuilder(context, FavouriteDB::class.java,"favourite_db")
            .fallbackToDestructiveMigration()
            .build()
}
