package com.swhite.cleanarchitecturenotes.feature_note.domain.util

//Used to hold different filter options for viewing notes.
sealed class OrderType{
    object Ascending: OrderType()
    object Descending: OrderType()
}
