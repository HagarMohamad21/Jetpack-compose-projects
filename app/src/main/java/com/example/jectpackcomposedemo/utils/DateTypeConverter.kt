package com.example.jectpackcomposedemo.utils

import androidx.room.TypeConverter
import java.util.*

class DateTypeConverter {

        @TypeConverter
        fun toDate(timestamp: Long?): Date? {
            return timestamp?.let { Date(it) }
        }

        @TypeConverter
        fun toTimestamp(date: Date?): Long? {
            return date?.time
        }
    }
