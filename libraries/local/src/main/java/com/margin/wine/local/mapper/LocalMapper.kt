package com.margin.wine.local.mapper

interface LocalMapper<D, E> {
    fun toEntity(data: D): E
    fun toEntities(data: List<D>): List<E> = data.map { toEntity(it) }

    fun toData(entity: E): D
    fun toDataList(entities: List<E>): List<D> = entities.map { toData(it) }
}