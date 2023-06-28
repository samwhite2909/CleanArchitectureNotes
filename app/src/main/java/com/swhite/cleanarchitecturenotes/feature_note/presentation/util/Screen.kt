package com.swhite.cleanarchitecturenotes.feature_note.presentation.util

//Contains screens used in the app for navigation.
sealed class Screen(val route: String) {
    object NotesScreen: Screen("notes-screen")
    object AddEditNoteScreen: Screen("add-edit-note-screen")
}
