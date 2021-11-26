package com.margin.wine.local.room.dao

import androidx.room.*
import com.margin.wine.local.room.entity.WineNoteEntity

@Dao
interface WineNoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWineNote(wine: WineNoteEntity)

    @Query("DELETE FROM wine_note WHERE id == :id")
    suspend fun delete(id: Int)

    @Query("SELECT * FROM wine_note WHERE id == :id")
    suspend fun getWineNoteById(id: Int): WineNoteEntity

    @Query("SELECT * FROM wine_note")
    suspend fun getWineNoteList(): List<WineNoteEntity>

}