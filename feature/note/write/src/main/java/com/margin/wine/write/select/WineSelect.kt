package com.margin.wine.write.select

data class WineSelect(
    val text: String,
    val id: Int = 0,
    var checked: Boolean = false
) {
    companion object {
        fun getWineSelectList(): ArrayList<WineSelect> {
            return arrayListOf(
                WineSelect(text="레드"),
                WineSelect(text="화이트"),
                WineSelect(text="로제"),
                WineSelect(text="스파클링"),
            )
        }


        fun getWineCountryList(): ArrayList<WineSelect> {
            return arrayListOf(
                WineSelect(text="\uD83C\uDDEE\uD83C\uDDF9 이탈리아"),
                WineSelect(text="\uD83C\uDDEB\uD83C\uDDF7 프랑스"),
                WineSelect(text="\uD83C\uDDE8\uD83C\uDDE6 캐나다"),
                WineSelect(text="\uD83C\uDDFA\uD83C\uDDF8 미국"),
            )
        }

        fun getWineAlcoholContentList(): ArrayList<WineSelect> {
            return arrayListOf(
                WineSelect(text="11% 이하"),
                WineSelect(text="11 - 12%"),
                WineSelect(text="13 - 14%"),
                WineSelect(text="15 - 16%"),
            )
        }

        fun getWineScentList() = arrayListOf(
            WineSelect(text="\uD83C\uDF47 포도"),
            WineSelect(text="\uD83C\uDF30 견과류"),
            WineSelect(text="\uD83E\uDD55 당근"),
            WineSelect(text="\uD83C\uDF32 우디"),
        )
    }
}