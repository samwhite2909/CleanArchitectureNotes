package com.swhite.cleanarchitecturenotes.feature_note.data.repository

import com.swhite.cleanarchitecturenotes.feature_note.data.data_source.NoteDao
import com.swhite.cleanarchitecturenotes.feature_note.domain.model.Note
import com.swhite.cleanarchitecturenotes.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

//Implementation for the notes repo, currently acting as a layer between the dao and the repo calls.
class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }
}