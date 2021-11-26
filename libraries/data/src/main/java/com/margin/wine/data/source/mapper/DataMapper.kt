package com.margin.wine.data.source.mapper

interface DataMapper<Domain, Data> {
    fun toDomain(data: Data): Domain
    fun toDomains(data: List<Data>): List<Domain> = data.map { toDomain(it) }

    fun toData(domain: Domain): Data
    fun toDataList(domains: List<Domain>): List<Data> = domains.map { toData(it) }
}