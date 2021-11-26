package com.margin.wine.note.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.margin.wine.domain.Result
import com.margin.wine.domain.model.WineNote
import com.margin.wine.domain.usecase.note.detail.LoadWineDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteDetailViewModel @Inject constructor(
    private val loadWineDetailUseCase: LoadWineDetailUseCase
) : ViewModel() {

    private val _wineNoteFlow = MutableStateFlow<Result<WineNote>>(Result.Loading)
    val wineNoteFlow: StateFlow<Result<WineNote>> = _wineNoteFlow

    fun loadWineNote(id: Int) = viewModelScope.launch{
        _wineNoteFlow.emit(loadWineDetailUseCase(id))
    }

}