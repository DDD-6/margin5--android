package com.margin.wine.wine.model

sealed class WineListUiModel {
    data class WineList(
        val name: String,
        val nameEng: String,
        val type: String, // Red, White
        val country: String, // Italy, Korean
        val region: String,
        val alcoholContent: Float,
        val ml: Int,
        val price: Int,
    ) : WineListUiModel()

    data class WineListVertical(
        val title: String,
        val subtitle: String,
        val country: String,
        val region: String,
        val type: String,
        val alcoholContent: Float,
        val ml: Int,
        val price: Int,
    ) : WineListUiModel()

    data class Knowledge(
        val header: String,
        val title: String,
        val desc: String
    ) : WineListUiModel()

    companion object {
        fun mock() = listOf(
            WineList(
                name = "에스 쿠이코 오크드 샤도네이",
                nameEng = "Es Cuiko Oaked Chardonnay, 2019",
                price = 75000,
                type = "Red",
                country = "브라질",
                alcoholContent = 12.6f,
                ml = 750,
                region = "쿠리코 밸리"
            ),
            WineList(
                name = "에스 쿠이코 오크드 샤도네이",
                nameEng = "Es Cuiko Oaked Chardonnay, 2019",
                price = 75000,
                type = "Red",
                country = "브라질",
                alcoholContent = 12.6f,
                ml = 750,
                region = "쿠리코 밸리"
            ),
            Knowledge(
                header = "오늘의\n지식",
                title = "테루아를 순수하게 \n표현한 내추럴 와인\uD83C\uDF77",
                desc = "이산화향 첨가물을 일체 사용하지 않은 와인\n" +
                        "으로 진한 보라 빛을 띠고 있다. 검은 라즈베리\n" +
                        "와 초콜렛으로 코팅된 체리 그리고 야생\n" +
                        " 블루베리의 향을 느낄 수 있다. 미디엄 플러스\n" +
                        "의 바디감을 가진 이 와인은 단단하고 굵은\n" +
                        "입자감의 타닌과 신선함을 입 안 가득 느낄\n" +
                        "수 있는 와인이다."
            ),
            WineListVertical(
                title = "달달구리 최고봉 ",
                subtitle = "샤또 롱보, 리브잘트 앙브레 \uD83C\uDDEB\uD83C\uDDF7 ",
                price = 75000,
                type = "Red",
                country = "브라질",
                alcoholContent = 12.6f,
                ml = 750,
                region = "쿠리코 밸리"
            ),
            WineListVertical(
                title = "달달구리 최고봉 ",
                subtitle = "샤또 롱보, 리브잘트 앙브레 \uD83C\uDDEB\uD83C\uDDF7 ",
                price = 75000,
                type = "Red",
                country = "브라질",
                alcoholContent = 12.6f,
                ml = 750,
                region = "쿠리코 밸리"
            )
        )
    }
}
