package com.neoapp.noteapplicationcompose.data

import com.neoapp.noteapplicationcompose.model.Note

class NoteDataSource{
    fun loadNote() : List<Note>{
        return listOf(
            Note(title = "A Good Day" , description = "Now I do have a lot of notes, so I'm just going to copy all of them and add them here so you don't"),
            Note(title = "A Day" , description = "Now I do have a lhere so you don't"),
            Note(title = "A Good Boy" , description = "So I'm just going to copy all of them and add them here so you don't"),
            Note(title = "A Good Day" , description = "Now I do have a lot of notes, so I'm just going to copy all of them and add them here so you don't"),
            Note(title = "A Good Day" , description = "Now I do have a lot of notes, so I'm just going to copy all of them and add them here so you don't"),
            Note(title = "A Good Day" , description = "Now I do have a lot of notes, so I'm just going to copy all of them and add them here so you don't"),
            Note(title = "A Good Day" , description = "Now I do have a lot of notes, so I'm just going to copy all of them and add them here so you don't"),
            Note(title = "A Good Day" , description = "Now I do have a lot of notes, so I'm just going to copy all of them and add them here so you don't"),
            Note(title = "A Good Day" , description = "Now I do have a lot of notes, so I'm just going to copy all of them and add them here so you don't")
        )
    }
}