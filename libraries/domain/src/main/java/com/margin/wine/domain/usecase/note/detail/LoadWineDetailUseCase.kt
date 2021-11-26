package com.margin.wine.domain.usecase.note.detail

import com.margin.wine.domain.IoDispatcher
import com.margin.wine.domain.model.WineNote
import com.margin.wine.domain.repository.WineNoteRepository
import com.margin.wine.domain.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class LoadWineDetailUseCase @Inject constructor(
    private val wineNoteRepository: WineNoteRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher,
) : UseCase<Int, WineNote>(dispatcher) {

    override suspend fun execute(param: Int): WineNote {
        return wineNoteRepository.getWineNote(param)
    }

}