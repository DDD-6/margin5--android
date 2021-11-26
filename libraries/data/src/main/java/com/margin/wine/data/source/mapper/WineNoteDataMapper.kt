package com.margin.wine.data.source.mapper

import com.margin.wine.data.source.model.WineNoteData
import com.margin.wine.domain.model.Wine
import com.margin.wine.domain.model.WineNote
import javax.inject.Inject

class WineNoteDataMapper @Inject constructor() : DataMapper<WineNote, WineNoteData> {

    override fun toDomain(data: WineNoteData) = WineNote(
        id = data.id,
        title = data.title,
        date = data.date,
        cardType = data.cardType,
        thumbnails = data.thumbnails,
        note = data.note,
        tags = data.tags,
        wine = Wine(
            name = data.wineName,
            type = data.wineType,
            price = data.winePrice,
            country = data.wineCountry,
            alcoholContent = data.wineAlcoholContent
        ),
        body = data.body,
        sweet = data.sweet,
        acid = data.acid,
        scentOne = data.scentOne,
        scentTwo = data.scentTwo,
        scentThree = data.scentThree,
        rating = data.rating
    )

    override fun toData(domain: WineNote) = WineNoteData(
        id = domain.id,
        title = domain.title,
        date = domain.date,
        cardType = domain.cardType,
        thumbnails = domain.thumbnails,
        note = domain.note,
        tags = domain.tags,
        body = domain.body,
        sweet = domain.sweet,
        acid = domain.acid,
        scentOne = domain.scentOne,
        scentTwo = domain.scentTwo,
        scentThree = domain.scentThree,
        rating = domain.rating,
        wineName = domain.wine.name,
        wineType = domain.wine.type,
        wineCountry = domain.wine.country,
        winePrice = domain.wine.price,
        wineAlcoholContent = domain.wine.alcoholContent
    )

}