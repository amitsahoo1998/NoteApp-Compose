package com.neoapp.noteapplicationcompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.neoapp.noteapplicationcompose.model.Note
import com.neoapp.noteapplicationcompose.util.DateConverter
import com.neoapp.noteapplicationcompose.util.UUIDConverter

@Database(entities = [Note::class] , version = 1 , exportSchema = false)
@TypeConverters(DateConverter::class,UUIDConverter::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao() : NoteDatabaseDao
}