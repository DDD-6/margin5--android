package com.margin.wine.write

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.margin.wine.core.ext.currentDate
import com.margin.wine.domain.Result
import com.margin.wine.domain.model.WineNote
import com.margin.wine.domain.usecase.note.write.SaveWineNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@HiltViewModel
class NoteWriteViewModel @Inject constructor(
    private val saveWineNoteUseCase: SaveWineNoteUseCase
) : ViewModel() {

    val images: ArrayList<Uri> = arrayListOf()

    private val _event = MutableStateFlow<NoteWriteEvent>(NoteWriteEvent.Init)
    val event: StateFlow<NoteWriteEvent> = _event

    var wineNote = WineNote(
        date = currentDate()
    )

    fun saveWineNote() = viewModelScope.launch {
        when(saveWineNoteUseCase(wineNote)){
            is Result.Loading -> { }
            is Result.Success -> { _event.emit(NoteWriteEvent.Close) }
            is Result.Error -> { }
        }
    }
}