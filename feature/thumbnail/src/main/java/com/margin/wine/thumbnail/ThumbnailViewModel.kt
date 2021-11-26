package com.margin.wine.thumbnail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.margin.wine.domain.Result
import com.margin.wine.domain.model.WineNote
import com.margin.wine.domain.usecase.note.LoadWineNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ThumbnailViewModel @Inject constructor(
    private val loadWineNoteUseCase: LoadWineNoteUseCase
) : ViewModel() {

    val wineNoteList = MutableStateFlow<List<ThumbnailViewState>>(listOf())

    init {
        viewModelScope.launch {
            when(val result = loadWineNoteUseCase(Any())) {
                is Result.Success -> {
                   wineNoteList.value = result.data.map(::mapToThumbnailViewState)
                }
            }
        }
    }

    fun asd() = viewModelScope.launch{

    }

    private fun mapToThumbnailViewState(wineNote: WineNote) = ThumbnailViewState(
        id = 0,
        cardType = wineNote.cardType,
        thumbnail = "",
        title = wineNote.title,
        note = wineNote.note,
        wineName = wineNote.wine.name,
        wineType = wineNote.wine.type,
        date = wineNote.date,
        type = ThumbnailType.CARD
    )
}