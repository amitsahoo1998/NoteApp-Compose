package com.neoapp.noteapplicationcompose.screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.neoapp.noteapplicationcompose.data.NoteDataSource
import com.neoapp.noteapplicationcompose.model.Note

class NoteViewModel : ViewModel() {

    private var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NoteDataSource().loadNote())
    }

    fun addNote(note : Note){
        noteList.add(note)
    }
    fun removeNote(note : Note){
        noteList.remove(note)
    }
    fun getAllNotes() : List<Note>{
        return noteList
    }
}