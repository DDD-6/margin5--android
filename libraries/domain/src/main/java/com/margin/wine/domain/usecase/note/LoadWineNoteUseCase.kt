package com.margin.wine.domain.usecase.note

import com.margin.wine.domain.IoDispatcher
import com.margin.wine.domain.model.WineNote
import com.margin.wine.domain.repository.WineNoteRepository
import com.margin.wine.domain.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class LoadWineNoteUseCase @Inject constructor(
    private val wineNoteRepository: WineNoteRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher,
) : UseCase<Any, List<WineNote>>(dispatcher) {

    override suspend fun execute(param: Any): List<WineNote> {
        return wineNoteRepository.getWineNoteList()
    }
}