package com.example.jectpackcomposedemo.domain.model

import android.os.Build
import android.os.Parcelable
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "fav_tbl")
//data class Favorite(
//    @NonNull
//    @PrimaryKey
//    @ColumnInfo(name = "city")
//    val city: String,
//
//    @ColumnInfo(name = "country")
//    val country: String)



@RequiresApi(Build.VERSION_CODES.O)
@Entity(tableName = "fav_tbl")
data class Favorite(
    @PrimaryKey
    val city:String
)
