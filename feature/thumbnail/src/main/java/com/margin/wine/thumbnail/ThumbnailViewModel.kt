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

    private fun mapToThumbnailViewState(wineNote: WineNote) = ThumbnailViewState(
        id = wineNote.id,
        cardType = wineNote.cardType,
        thumbnail = wineNote.thumbnails.firstOrNull()?:"",
        title = wineNote.title,
        note = wineNote.note,
        wineName = wineNote.wine.name,
        wineType = wineNote.wine.type,
        date = wineNote.date,
        type = if (wineNote.thumbnails.isNotEmpty()) ThumbnailType.NORMAL else ThumbnailType.CARD
    )
}