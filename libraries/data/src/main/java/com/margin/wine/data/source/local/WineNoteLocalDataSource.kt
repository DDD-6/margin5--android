package com.margin.wine.data.source.local

import com.margin.wine.data.source.model.WineNoteData

interface WineNoteLocalDataSource {

    suspend fun save(wineNoteData: WineNoteData)

    suspend fun delete(id: Int)

    suspend fun getWineNoteDataById(id: Int): WineNoteData

    suspend fun getWineNoteDataList(): List<WineNoteData>

}