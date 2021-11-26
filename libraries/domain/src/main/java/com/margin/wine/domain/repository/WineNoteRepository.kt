package com.margin.wine.domain.repository

import com.margin.wine.domain.model.WineNote

interface WineNoteRepository {

    suspend fun save(wineNote: WineNote)

    suspend fun getWineNoteList(): List<WineNote>

}