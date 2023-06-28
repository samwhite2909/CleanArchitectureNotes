package com.swhite.cleanarchitecturenotes.feature_note.domain.use_case

import com.swhite.cleanarchitecturenotes.feature_note.domain.model.Note
import com.swhite.cleanarchitecturenotes.feature_note.domain.repository.NoteRepository

//Use case for getting a specific note by ID.
class GetNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Note? {
        //Get the note from the db using an id and the repo.
        return repository.getNoteById(id)
    }
}