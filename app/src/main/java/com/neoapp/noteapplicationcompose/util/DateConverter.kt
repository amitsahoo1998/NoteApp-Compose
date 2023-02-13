package com.neoapp.noteapplicationcompose.util

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
    @TypeConverter
    fun dateToTimeStamp(date: Date):Long{
        return date.time
    }
    @TypeConverter
    fun timeStampToDate(timeStamp : Long):Date?{
        return Date(timeStamp)
    }
}