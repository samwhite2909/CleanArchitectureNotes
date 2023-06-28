package com.swhite.cleanarchitecturenotes.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.swhite.cleanarchitecturenotes.ui.theme.*


//Model class for notes.
@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    //List of colors available for notes.
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

//Allows for an exception to be returned for incorrect notes.
class InvalidNoteException(message: String) : Exception(message)
