package com.margin.wine.data.source.model

data class WineNoteData(
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
    val wineCountry: String,
    val winePrice: Int
)