package com.margin.wine.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.margin.wine.local.room.entity.WineNoteEntity

@Dao
interface WineNoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWineNote(wine: WineNoteEntity)

    @Query("SELECT * FROM wine_note WHERE id == :id")
    suspend fun getWineNoteById(id: Int): WineNoteEntity

    @Query("SELECT * FROM wine_note")
    suspend fun getWineNoteList(): List<WineNoteEntity>

}