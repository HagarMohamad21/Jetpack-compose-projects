package com.example.jectpackcomposedemo.domain.model


import android.os.Build
import android.os.Parcelable
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.jectpackcomposedemo.utils.DateTypeConverter
import kotlinx.android.parcel.Parcelize
import java.time.Instant
import java.util.*


@Entity(tableName = "notes_table")
@RequiresApi(Build.VERSION_CODES.O)
@Parcelize
data class Note
public constructor(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name="note_title")
    val title: String,

    @ColumnInfo(name="note_description")
    val description: String,

    @ColumnInfo(name="note_date")
    @TypeConverters(DateTypeConverter::class)
    val creationDate: Date = Date.from(Instant.now())
):Parcelable
