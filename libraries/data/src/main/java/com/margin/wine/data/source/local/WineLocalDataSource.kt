package com.margin.wine.data.source.local

import com.margin.wine.data.source.model.WineData
import kotlinx.coroutines.flow.Flow

interface WineLocalDataSource {
    fun fetchHomeCachingWineList(): List<WineData>

    suspend fun getAllWineListByCaching(): Flow<List<WineData>>

    suspend fun insertWineDetail(wineEntity: WineData)
}