package com.swhite.cleanarchitecturenotes.feature_note.domain.use_case

import com.swhite.cleanarchitecturenotes.feature_note.domain.model.Note
import com.swhite.cleanarchitecturenotes.feature_note.domain.repository.NoteRepository

//Use case for deleting notes from the db.
class DeleteNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        //Delete the note from the db using the repo.
        repository.deleteNote(note)
    }
}