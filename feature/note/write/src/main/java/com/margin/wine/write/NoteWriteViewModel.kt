package com.margin.wine.write

import androidx.lifecycle.ViewModel
import com.margin.wine.domain.model.WineNote
import kotlinx.coroutines.flow.MutableStateFlow

class NoteWriteViewModel : ViewModel() {

    var wineNote = WineNote()


    fun saveWineNote() {

        wineNote.wine.type
    }

}