package com.margin.wine.thumbnail

data class ThumbnailViewState(
    val id: Int,
    val cardType: Int,
    val thumbnail: String,
    val title: String,
    val note: String,
    val wineName: String,
    val wineType: String,
    val date: String,
    val type: ThumbnailType
) {
    companion object {
        fun mock() = List(10) {
            ThumbnailViewState(
                id = 0,
                cardType = 1,
                thumbnail = "https://firebasestorage.googleapis.com/v0/b/wine-948db.appspot.com/o/sample_thumbnail_1.png?alt=media&token=5d50943c-4f48-4a15-97ee-7fdc344d8ba2",
                title = "한남동 와인바에서 지효랑 내추럴와인 도전",
                note = "사진 없이 글로 적는 와인노트.",
                wineName = "생 미셸 와인 에스테이트",
                wineType = "화이트",
                date = "2020/10/10/월",
                type = listOf(
                    ThumbnailType.CARD,
                    ThumbnailType.NORMAL
                ).shuffled().first()

            )
        }
    }
}