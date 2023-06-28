package com.swhite.cleanarchitecturenotes.feature_note.domain.use_case

//Contains the note use cases, easier to inject.
data class NoteUseCases(
    val getNotesUseCase: GetNotesUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase,
    val addNote: AddNoteUseCase,
    val getNote: GetNoteUseCase
)
