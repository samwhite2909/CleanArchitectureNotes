package com.swhite.cleanarchitecturenotes.feature_note.presentation.add_edit_note

//Saved states for a text field.
data class NoteTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)