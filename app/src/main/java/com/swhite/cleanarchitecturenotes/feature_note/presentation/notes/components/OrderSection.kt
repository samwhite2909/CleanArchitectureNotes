package com.swhite.cleanarchitecturenotes.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.swhite.cleanarchitecturenotes.R
import com.swhite.cleanarchitecturenotes.feature_note.domain.util.NoteOrder
import com.swhite.cleanarchitecturenotes.feature_note.domain.util.OrderType

//Filter options selection composable.
@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            //Adding in the different radio button options.
            DefaultRadioButton(
                text = stringResource(R.string.title_radio_button),
                selected = noteOrder is NoteOrder.Title,
                onSelect = { onOrderChange(NoteOrder.Title(noteOrder.orderType)) }
            )
            Spacer(
                modifier = Modifier.width(8.dp)
            )
            DefaultRadioButton(
                text = stringResource(R.string.date_radio_button),
                selected = noteOrder is NoteOrder.Date,
                onSelect = { onOrderChange(NoteOrder.Date(noteOrder.orderType)) }
            )
            Spacer(
                modifier = Modifier.width(8.dp)
            )
            DefaultRadioButton(
                text = stringResource(R.string.color_radio_button),
                selected = noteOrder is NoteOrder.Color,
                onSelect = { onOrderChange(NoteOrder.Color(noteOrder.orderType)) }
            )
        }
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = stringResource(R.string.ascending_radio_button),
                selected = noteOrder.orderType is OrderType.Ascending,
                onSelect = { onOrderChange(noteOrder.copy(OrderType.Ascending)) }
            )
            Spacer(
                modifier = Modifier.width(8.dp)
            )
            DefaultRadioButton(
                text = stringResource(R.string.descending_radio_button),
                selected = noteOrder.orderType is OrderType.Descending,
                onSelect = { onOrderChange(noteOrder.copy(OrderType.Descending)) }
            )
        }

    }
}