package com.neoapp.noteapplicationcompose.screen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Insert
import com.neoapp.noteapplicationcompose.data.NoteDataSource
import com.neoapp.noteapplicationcompose.model.Note
import com.neoapp.noteapplicationcompose.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

    //private var noteList = mutableStateListOf<Note>()
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getAllNotes().distinctUntilChanged().collect{listOfNote ->
                if (listOfNote.isNullOrEmpty()){
                    Log.d("empty", ": empty list")
                }else{
                    _noteList.value  = listOfNote
                }
            }
        }
        //noteList.addAll(NoteDataSource().loadNote())
    }

    fun addNote(note : Note)= viewModelScope.launch { repository.addNote(note) }
    fun updateNote(note : Note)= viewModelScope.launch { repository.updateNote(note) }
    fun removeNote(note : Note)= viewModelScope.launch { repository.deleteNote(note) }

}