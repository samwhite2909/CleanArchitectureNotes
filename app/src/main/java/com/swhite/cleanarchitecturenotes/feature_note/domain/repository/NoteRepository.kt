package com.swhite.cleanarchitecturenotes.feature_note.domain.repository

import com.swhite.cleanarchitecturenotes.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

//Repo containing calls to implementation for db operations on notes.
interface NoteRepository {

    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}