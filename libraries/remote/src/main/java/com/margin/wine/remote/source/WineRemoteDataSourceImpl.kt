package com.margin.wine.remote.source

import com.margin.wine.data.source.model.WineData
import com.margin.wine.data.source.remote.WineRemoteDataSource

class WineRemoteDataSourceImpl : WineRemoteDataSource {
    override fun fetchHomeWineList(): List<WineData> {
        return List(10) { WineData() }
    }
}