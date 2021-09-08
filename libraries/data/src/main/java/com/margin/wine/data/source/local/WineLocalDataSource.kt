package com.margin.wine.data.source.local

import com.margin.wine.data.source.model.WineData

interface WineLocalDataSource {
    fun fetchHomeCachingWineList(): List<WineData>
}