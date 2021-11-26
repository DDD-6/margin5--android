package com.margin.wine.local.mapper

import com.margin.wine.data.source.model.WineNoteData
import com.margin.wine.local.room.entity.WineNoteEntity
import javax.inject.Inject
import kotlin.reflect.typeOf

class WineNoteLocalMapper @Inject constructor() : LocalMapper<WineNoteData, WineNoteEntity> {
    override fun toEntity(data: WineNoteData) = WineNoteEntity(
        id = 0,
        title = data.title,
        date = data.date,
        cardType = data.cardType,
        thumbnails = data.thumbnails,
        note = data.note,
        tags = data.tags,
        body = data.body,
        sweet = data.sweet,
        acid = data.acid,
        scentOne = data.scentOne,
        scentTwo = data.scentTwo,
        scentThree = data.scentThree,
        rating = data.rating,
        wineName = data.wineName,
        wineType = data.wineType,
        wineCountry = data.wineCountry,
        winePrice = data.winePrice,
        wineAlcoholContent = data.wineAlcoholContent
    )

    override fun toData(entity: WineNoteEntity) = WineNoteData(
        id = entity.id,
        title = entity.title,
        date = entity.date,
        cardType = entity.cardType,
        thumbnails = entity.thumbnails,
        note = entity.note,
        tags = entity.tags,
        body = entity.body,
        sweet = entity.sweet,
        acid = entity.acid,
        scentOne = entity.scentOne,
        scentTwo = entity.scentTwo,
        scentThree = entity.scentThree,
        rating = entity.rating,
        wineName = entity.wineName,
        wineType = entity.wineType,
        wineCountry = entity.wineCountry,
        winePrice = entity.winePrice,
        wineAlcoholContent = entity.wineAlcoholContent
    )
}