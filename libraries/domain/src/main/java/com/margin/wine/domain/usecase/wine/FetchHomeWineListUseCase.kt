package com.margin.wine.domain.usecase.wine

import com.margin.wine.domain.model.Wine
import com.margin.wine.domain.repository.WineRepository
import com.margin.wine.domain.usecase.NonParamCoroutineUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class FetchHomeWineListUseCase(
    private val wineRepository: WineRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : NonParamCoroutineUseCase<List<Wine>>(ioDispatcher) {
    override suspend fun execute(): List<Wine> {
        return wineRepository.fetchHomeData()
    }
}