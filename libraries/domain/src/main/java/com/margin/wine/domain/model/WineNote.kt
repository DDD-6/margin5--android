package com.margin.wine.domain.model

data class WineNote(
    val title: String = "",
    val date: String = "",
    val cardType: Int = 0,
    val thumbnails: List<String> = listOf(),
    val note: String = "",
    val tags: List<String> = listOf(),
    val wine: Wine = Wine(),
    val body: Int = 0,
    val sweet: Int = 0,
    val acid: Int = 0,
    val scentOne: String = "",
    val scentTwo: String = "",
    val scentThree: String = "",
    val rating: Int = 0
) {
    companion object {
        fun mock() = WineNote(
            title = "오늘도 한  잔\uD83C\uDF77",
            date = "2020/10/10/월",
            cardType = 1,
            thumbnails = listOf(),
            note = "사진 없이 글로 적는 와인노트. 사진 없이 글로 적는 와인 노트. 사진 없이 글로 적는 와인노트. 사진 없이 글로 적는 와인노트. 사진 없이 글로 적는 와인노트. ",
            tags = listOf(),
            wine = Wine.mock(),
            body = 2,
            sweet = 4,
            acid = 1,
            scentOne = "\uD83C\uDF47 포도",
            scentTwo = "\uD83C\uDF32 우디향",
            scentThree = "\uD83C\uDF30 견과류 ",
            rating = 4
        )
    }
}