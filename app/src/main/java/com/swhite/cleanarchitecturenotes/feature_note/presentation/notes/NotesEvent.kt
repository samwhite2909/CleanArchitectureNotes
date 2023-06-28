package com.swhite.cleanarchitecturenotes.feature_note.presentation.notes

import com.swhite.cleanarchitecturenotes.feature_note.domain.model.Note
import com.swhite.cleanarchitecturenotes.feature_note.domain.util.NoteOrder

//All events that could happen on the notes screen.
sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder) : NotesEvent()
    data class DeleteNote(val note: Note) : NotesEvent()
    object RestoreNote : NotesEvent()
    object ToggleOrderSection : NotesEvent()
}
