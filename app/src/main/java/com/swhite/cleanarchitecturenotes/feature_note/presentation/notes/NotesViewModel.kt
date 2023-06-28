package com.swhite.cleanarchitecturenotes.feature_note.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.swhite.cleanarchitecturenotes.feature_note.domain.model.Note
import com.swhite.cleanarchitecturenotes.feature_note.domain.use_case.NoteUseCases
import com.swhite.cleanarchitecturenotes.feature_note.domain.util.NoteOrder
import com.swhite.cleanarchitecturenotes.feature_note.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

//VM for the notes screen.
@HiltViewModel
class NotesViewModel @Inject constructor(
    private val notesUseCases: NoteUseCases
) : ViewModel() {

    //Saves the state of the notes.
    private val _state = mutableStateOf<NotesState>(NotesState())
    val state: State<NotesState> = _state

    //Keeps a reference to the last deleted note to restore it from 'undo' on the snackbar.
    private var recentlyDeletedNote: Note? = null

    private var getNotesJob: Job? = null

    //Initially sets the notes to order by date desc.
    init {
        getNotes(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: NotesEvent) {
        when (event) {
            //Order notes based on user selection.
            is NotesEvent.Order -> {
                //If it's the same, don't change it.
                if (state.value.noteOrder::class == event.noteOrder::class &&
                    state.value.noteOrder.orderType == event.noteOrder.orderType
                ) {
                    return
                }
                getNotes(event.noteOrder)
            }
            //Delete a note if requested.
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    notesUseCases.deleteNoteUseCase(event.note)
                    recentlyDeletedNote = event.note
                }
            }
            //Restore the recently deleted note if requested.
            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    notesUseCases.addNote(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }

            }
            //Show/hide the filtering.
            is NotesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    //Gets a list of all notes.
    private fun getNotes(noteOrder: NoteOrder) {
        getNotesJob?.cancel()
        getNotesJob = notesUseCases.getNotesUseCase(noteOrder)
            .onEach { notes ->
                _state.value = state.value.copy(
                    notes = notes,
                    noteOrder = noteOrder
                )
            }
            .launchIn(viewModelScope)
    }
}