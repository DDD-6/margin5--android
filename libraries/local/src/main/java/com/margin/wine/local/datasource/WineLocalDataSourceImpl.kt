package com.margin.wine.local.datasource

import com.margin.wine.data.source.local.WineLocalDataSource
import com.margin.wine.data.source.model.WineData
import javax.inject.Inject

class WineLocalDataSourceImpl @Inject constructor() : WineLocalDataSource {
    override fun fetchHomeCachingWineList(): List<WineData> {
        return List(10) { WineData() }
    }
}