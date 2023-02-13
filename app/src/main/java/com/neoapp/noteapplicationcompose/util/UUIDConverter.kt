package com.neoapp.noteapplicationcompose.util

import androidx.room.TypeConverter
import java.util.UUID

class UUIDConverter {

    @TypeConverter
    fun uuidToString(uuid: UUID):String?{
        return uuid.toString()
    }

    @TypeConverter
    fun stringToUUID(string: String):UUID?{
        return UUID.fromString(string)
    }

}
