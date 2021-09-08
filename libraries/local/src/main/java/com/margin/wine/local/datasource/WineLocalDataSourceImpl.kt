package com.margin.wine.local.datasource

import com.margin.wine.data.source.local.WineLocalDataSource
import com.margin.wine.data.source.model.WineData

class WineLocalDataSourceImpl : WineLocalDataSource {
    override fun fetchHomeCachingWineList(): List<WineData> {
        return List(10) { WineData() }
    }
}