package com.margin.wine.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wine")
data class  WineEntity(
    @PrimaryKey
    val id: Int,
    val name: String
)