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
                nameEng = "Es Cuiko Oaked Chardonnay",
                vintage = 2021,
                price = 10000,
                type = "레드",
                country = "Italy",
                region = "쿠리코 밸리",
                alcoholContent = 17.5f,
                ml = 750,
            )
        }
    }
}