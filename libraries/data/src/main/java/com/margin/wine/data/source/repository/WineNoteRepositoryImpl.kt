package com.margin.wine.data.source.repository

import com.margin.wine.data.source.local.WineNoteLocalDataSource
import com.margin.wine.data.source.mapper.WineNoteDataMapper
import com.margin.wine.domain.model.WineNote
import com.margin.wine.domain.repository.WineNoteRepository
import javax.inject.Inject

class WineNoteRepositoryImpl @Inject constructor(
     private val wineNoteLocalDataSource: WineNoteLocalDataSource,
     private val wineNoteDataMapper: WineNoteDataMapper
) : WineNoteRepository {

    override suspend fun save(wineNote: WineNote) {
        wineNoteLocalDataSource.save(wineNoteDataMapper.toData(wineNote))
    }

    override suspend fun getWineNoteList(): List<WineNote> {
        return wineNoteDataMapper.toDomains(wineNoteLocalDataSource.getWineNoteDataList())
    }

}