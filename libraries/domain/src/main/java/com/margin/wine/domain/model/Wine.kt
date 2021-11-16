package com.margin.wine.domain.model

data class Wine(
    val id: Int,
    val name: String,
    val price: Int,
    val type: String, // Red, White
    val country: String, // Italy, Korean
    val acid: String
)