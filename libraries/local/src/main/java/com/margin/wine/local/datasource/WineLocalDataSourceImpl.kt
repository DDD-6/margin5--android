package com.margin.wine.local.datasource

import com.margin.wine.data.source.local.WineLocalDataSource
import com.margin.wine.data.source.model.WineData
import com.margin.wine.local.room.dao.WineDao
import com.margin.wine.local.room.entity.WineEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WineLocalDataSourceImpl @Inject constructor(
    private val wineDao: WineDao
) : WineLocalDataSource {
    override fun fetchHomeCachingWineList(): List<WineData> {
        return List(10) { WineData() }
    }

    override suspend fun getAllWineListByCaching(): Flow<List<WineData>> {
        return wineDao.getWineListAsFlow()
            .map {
                it.map {  entity ->
                    WineData(
                        id = entity.id,
                        name = entity.name
                    )
                }
            }
    }

    override suspend fun insertWineDetail(wineEntity: WineData) {
        wineDao.insertWineDetail(
            WineEntity(
                id = wineEntity.id,
                name = wineEntity.name
            )
        )
    }
}