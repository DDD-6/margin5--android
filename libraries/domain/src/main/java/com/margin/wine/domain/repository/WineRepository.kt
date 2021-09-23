package com.margin.wine.domain.repository

import com.margin.wine.domain.model.Wine

interface WineRepository {
    fun fetchHomeData(): List<Wine>
}