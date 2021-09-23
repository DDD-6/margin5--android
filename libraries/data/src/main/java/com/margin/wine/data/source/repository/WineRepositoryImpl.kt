package com.margin.wine.data.source.repository

import com.margin.wine.data.source.local.WineLocalDataSource
import com.margin.wine.data.source.remote.WineRemoteDataSource
import com.margin.wine.domain.model.Wine
import com.margin.wine.domain.repository.WineRepository
import javax.inject.Inject

class WineRepositoryImpl @Inject constructor(
    private val wineRemoteDataSource: WineRemoteDataSource,
    private val wineLocalDataSource: WineLocalDataSource
) : WineRepository {
    override fun fetchHomeData(): List<Wine> {
        return (wineRemoteDataSource.fetchHomeWineList() + wineLocalDataSource.fetchHomeCachingWineList()).map { data ->
            Wine(
                id = data.id,
                name = data.name,
                aid = data.aid
            )
        }
    }
}