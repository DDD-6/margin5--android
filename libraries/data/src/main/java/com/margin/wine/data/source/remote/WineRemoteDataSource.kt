package com.margin.wine.data.source.remote

import com.margin.wine.data.source.model.WineData

interface WineRemoteDataSource {
    fun fetchHomeWineList(): List<WineData>
}