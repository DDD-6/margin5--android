package com.margin.wine.domain.usecase.note.detail

import com.margin.wine.domain.IoDispatcher
import com.margin.wine.domain.repository.WineNoteRepository
import com.margin.wine.domain.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class DeleteWineDetailUseCase @Inject constructor(
    private val wineNoteRepository: WineNoteRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher,
) : UseCase<Int, Any>(dispatcher) {

    override suspend fun execute(param: Int): Any {
        return wineNoteRepository.delete(param)
    }

}