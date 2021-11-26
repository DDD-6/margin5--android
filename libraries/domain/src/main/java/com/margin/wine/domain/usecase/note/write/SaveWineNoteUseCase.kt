package com.margin.wine.domain.usecase.note.write

import com.margin.wine.domain.IoDispatcher
import com.margin.wine.domain.model.WineNote
import com.margin.wine.domain.repository.WineNoteRepository
import com.margin.wine.domain.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SaveWineNoteUseCase @Inject constructor(
    private val wineNoteRepository: WineNoteRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher,
) : UseCase<WineNote, Any>(dispatcher) {
    override suspend fun execute(param: WineNote): Any {
        wineNoteRepository.save(param)
        return Any()
    }
}