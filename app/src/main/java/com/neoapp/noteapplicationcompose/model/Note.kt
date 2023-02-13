package com.neoapp.noteapplicationcompose.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey
    val id : UUID = UUID.randomUUID(),
    val title : String,
    val description : String,
    val entryDate : Date = Date.from(Instant.now())
)
