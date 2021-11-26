package com.margin.wine.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.margin.wine.local.converter.StringListConverter

@Entity(tableName = "wine_note")
@TypeConverters(StringListConverter::class)
data class WineNoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val date: String,
    val cardType: Int,
    val thumbnails: List<String>,
    val note: String,
    val tags: List<String>,
    val body: Int,
    val sweet: Int,
    val acid: Int,
    val scentOne: String,
    val scentTwo: String,
    val scentThree: String,
    val rating: Int,
    val wineName: String,
    val wineType: String,
    val winePrice: Int
)