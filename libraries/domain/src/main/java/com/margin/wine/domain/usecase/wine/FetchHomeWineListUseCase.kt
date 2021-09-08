package com.margin.wine.domain.usecase.wine

import com.margin.wine.domain.model.Wine
import com.margin.wine.domain.repository.WineRepository
import com.margin.wine.domain.usecase.NonParamCoroutineUseCase
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class FetchHomeWineListUseCase @Inject constructor(
    private val wineRepository: WineRepository
) : NonParamCoroutineUseCase<List<Wine>>(Dispatchers.IO) {
    override suspend fun execute(): List<Wine> {
        return wineRepository.fetchHomeData()
    }
}