package com.margin.wine.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.margin.wine.local.room.entity.WineEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WineDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWineDetail(wine: WineEntity)

    @Query("SELECT * FROM wine")
    fun getWineListAsFlow(): Flow<List<WineEntity>>
}