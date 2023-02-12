package com.neoapp.noteapplicationcompose.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun NoteInputText(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {},

    ) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(value = text,
        onValueChange = onTextChange,
        modifier = modifier,
        label = { Text(text = label)},
        colors = TextFieldDefaults.textFieldColors(textColor = Color.Black),
        maxLines = maxLine,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions (onDone = {
            onImeAction()
            keyboardController?.hide()
        })
    )
}

@Composable
fun NoteButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick : ()->Unit,
    enabled : Boolean = true
){
    Button(onClick = onClick ,
        modifier = modifier,
        enabled = enabled,
        shape = CircleShape
        ) {
        Text(text)
    }

}