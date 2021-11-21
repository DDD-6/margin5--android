package com.margin.wine.domain.model

data class Wine(
    val id: Int = 0,
    val name: String,
    val nameEng: String,
    val vintage: Int,
    val price: Int,
    val type: String, // Red, White
    val country: String, // Italy, Korean
    val region: String, // kurico vally
    val alcoholContent: Float,
    val ml: Int
) {
    companion object {
        fun mock() = Wine(
            name = "에스 쿠이코 오크드 샤도네이",
            nameEng = "Es Cuiko Oaked Chardonnay",
            vintage = 2021,
            price = 65000,
            type = "White",
            country = "칠레",
            region = "쿠리코 밸리",
            alcoholContent = 17.6f,
            ml = 750,
        )
    }
}