package com.margin.wine.note.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.margin.wine.domain.Result
import com.margin.wine.domain.model.WineNote
import com.margin.wine.domain.usecase.note.detail.DeleteWineDetailUseCase
import com.margin.wine.domain.usecase.note.detail.LoadWineDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteDetailViewModel @Inject constructor(
    private val loadWineDetailUseCase: LoadWineDetailUseCase,
    private val deleteWineDetailUseCase: DeleteWineDetailUseCase
) : ViewModel() {

    private val _wineNoteFlow = MutableStateFlow<Result<WineNote>>(Result.Loading)
    val wineNoteFlow: StateFlow<Result<WineNote>> = _wineNoteFlow

    private val _wineNoteDeleteFlow = MutableStateFlow<Result<String>>(Result.Loading)
    val wineNoteDeleteFlow: StateFlow<Result<String>> = _wineNoteDeleteFlow

    fun loadWineNote(id: Int) = viewModelScope.launch{
        _wineNoteFlow.emit(loadWineDetailUseCase(id))
    }

    fun delete(id: Int) = viewModelScope.launch {
        deleteWineDetailUseCase(id)
        _wineNoteDeleteFlow.emit(Result.Success("삭제되었습니다."))
    }
}