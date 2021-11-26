package com.margin.wine.local.datasource

import com.margin.wine.data.source.local.WineNoteLocalDataSource
import com.margin.wine.data.source.model.WineNoteData
import com.margin.wine.local.mapper.WineNoteLocalMapper
import com.margin.wine.local.room.dao.WineNoteDao
import javax.inject.Inject

class WineNoteLocalDataSourceImpl @Inject constructor(
    private val wineNoteDao: WineNoteDao,
    private val wineNoteLocalMapper: WineNoteLocalMapper
) : WineNoteLocalDataSource {

    override suspend fun save(wineNoteData: WineNoteData) {
        wineNoteDao.insertWineNote(wineNoteLocalMapper.toEntity(wineNoteData))
    }

    override suspend fun delete(id: Int) {
        wineNoteDao.delete(id)
    }

    override suspend fun getWineNoteDataById(id: Int): WineNoteData {
        return wineNoteLocalMapper.toData(wineNoteDao.getWineNoteById(id))
    }

    override suspend  fun getWineNoteDataList(): List<WineNoteData> {
        return wineNoteLocalMapper.toDataList(wineNoteDao.getWineNoteList())
    }
}