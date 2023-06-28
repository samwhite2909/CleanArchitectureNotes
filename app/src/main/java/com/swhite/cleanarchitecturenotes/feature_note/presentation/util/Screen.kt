package com.swhite.cleanarchitecturenotes.feature_note.presentation.util

sealed class Screen(val route: String) {
    object NotesScreen: Screen("notes-screen")
    object AddEditNoteScreen: Screen("add-edit-note-screen")
}
