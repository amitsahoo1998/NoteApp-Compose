package com.neoapp.noteapplicationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.neoapp.noteapplicationcompose.data.NoteDataSource
import com.neoapp.noteapplicationcompose.model.Note
import com.neoapp.noteapplicationcompose.screen.NoteScreen
import com.neoapp.noteapplicationcompose.screen.NoteViewModel
import com.neoapp.noteapplicationcompose.ui.theme.NoteApplicationComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteApplicationComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel : NoteViewModel by viewModels()
                    NotesApp(viewModel)
                }
            }
        }
    }
}

@Composable
fun NotesApp(noteViewModel: NoteViewModel){

    val noteList = noteViewModel.noteList.collectAsState().value
    NoteScreen(notes = noteList ,
        onAddNote = noteViewModel::addNote,
        onRemoveNote = noteViewModel::removeNote
    )
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteApplicationComposeTheme {

    }
}