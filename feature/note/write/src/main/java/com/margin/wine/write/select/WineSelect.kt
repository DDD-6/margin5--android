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
                WineSelect(text="\uD83C\uDDF0\uD83C\uDDF7 한국"),
                WineSelect(text="\uD83C\uDDE6\uD83C\uDDFA 호주"),
                WineSelect(text="\uD83C\uDDEA\uD83C\uDDF8 스페인"),
                WineSelect(text="\uD83C\uDDE8\uD83C\uDDF1 칠레"),
                WineSelect(text="\uD83C\uDDF5\uD83C\uDDF9 포르투칼"),
                WineSelect(text="\uD83C\uDDE9\uD83C\uDDEA 독일"),
                WineSelect(text="\uD83C\uDDE6\uD83C\uDDF7 아르헨티나"),
                WineSelect(text="\uD83C\uDDFF\uD83C\uDDE6 남아공"),
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

        fun getWineScentList2() = arrayListOf(
            WineSelect(text="\uD83C\uDF4E 사과"),
            WineSelect(text="\uD83E\uDD42 스파클링"),
            WineSelect(text="\uD83C\uDF4B 레몬"),
            WineSelect(text="\uD83C\uDF51 복숭아"),
        )

        fun getWineScentList3() = arrayListOf(
            WineSelect(text="\uD83C\uDF39 로즈"),
            WineSelect(text="\uD83C\uDF4A 오렌지"),
            WineSelect(text="\uD83C\uDF52 체리"),
            WineSelect(text="\uD83C\uDF6F 꿀"),
        )
    }
}