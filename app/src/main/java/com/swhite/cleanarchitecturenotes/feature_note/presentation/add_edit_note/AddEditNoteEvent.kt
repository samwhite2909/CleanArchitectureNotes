package com.swhite.cleanarchitecturenotes.feature_note.presentation.add_edit_note

import androidx.compose.ui.focus.FocusState

//All possible events that can happen on the add edit note screen.
sealed class AddEditNoteEvent {
    data class EnteredTitle(val value: String) : AddEditNoteEvent()
    data class ChangeTitleFocus(val focusState: FocusState) : AddEditNoteEvent()
    data class EnteredContent(val value: String) : AddEditNoteEvent()
    data class ChangeContentFocus(val focusState: FocusState) : AddEditNoteEvent()
    data class ChangedColor(val color: Int) : AddEditNoteEvent()
    object SaveNote : AddEditNoteEvent()
}

