package com.margin.wine.thumbnail

data class ThumbnailViewState(
    val thumbnail: String,
    val title: String,
    val date: String
) {
    companion object {
        fun mock() = List(10) {
            ThumbnailViewState(
                "https://firebasestorage.googleapis.com/v0/b/wine-948db.appspot.com/o/sample_thumbnail_1.png?alt=media&token=5d50943c-4f48-4a15-97ee-7fdc344d8ba2",
                "한남동 와인바에서 지효랑 내추럴와인 도전",
                "2020/10/10/월"
            )
        }
    }
}