package com.neoapp.noteapplicationcompose.screen

import android.graphics.drawable.Icon
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.neoapp.noteapplicationcompose.R
import com.neoapp.noteapplicationcompose.components.NoteButton
import com.neoapp.noteapplicationcompose.components.NoteInputText
import com.neoapp.noteapplicationcompose.data.NoteDataSource
import com.neoapp.noteapplicationcompose.model.Note
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
) {

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current


    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(title = {
            Text(text = stringResource(id = R.string.app_name))
        }, actions = {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "icon"
            )
        })
        //Content
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            NoteInputText(modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = title,
                label = "Title",
                onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) title = it
                })

            NoteInputText(modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = description,
                label = "Description",
                onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) description = it
                })

            NoteButton(text = "Save", onClick = {
                if (title.isNotEmpty() && description.isNotEmpty()) {
                    onAddNote(Note(title = title,
                    description = description))
                    title = ""
                    description = ""
                    Toast.makeText(context,"Note Added",
                                        Toast.LENGTH_LONG).show()
                }
            })

            Divider(modifier = Modifier.padding(10.dp))

            LazyColumn {
                items(notes) { note ->
                    NoteRow(note = note,
                        onNoteClicked = {onRemoveNote(note)})
                }
            }
        }
    }
}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClicked: (Note) -> Unit
) {
    Surface(
        modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp)),
        color = Color(0xFFDFE6EB),
        shadowElevation = 10.dp
    ) {
        Column(
            modifier
                .clickable{onNoteClicked.invoke(note)}
                .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start) {
            Text(text = note.title ,
                style = MaterialTheme.typography.titleMedium)
            Text(text = note.description ,
                style = MaterialTheme.typography.titleSmall)
            Text(
                text = note.entryDate.format(DateTimeFormatter.ofPattern("EEE , d MMM")),
                style = MaterialTheme.typography.bodyMedium
            )
        }


    }
}

@Preview(showBackground = true)
@Composable
fun NotesScreenPreview() {
    NoteScreen(notes = NoteDataSource().loadNote(), onAddNote = {}, onRemoveNote = {})
}