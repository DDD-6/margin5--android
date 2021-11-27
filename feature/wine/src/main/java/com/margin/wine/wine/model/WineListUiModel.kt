package com.margin.wine.wine.model

import com.margin.wine.wine.R

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
        val imgRes: Int
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
        val imgRes: Int
    ) : WineListUiModel()

    data class Knowledge(
        val header: String,
        val title: String,
        val desc: String
    ) : WineListUiModel()

    companion object {
        fun mock() = listOf(
            WineList(
                name = "투썩 점퍼 와인즈, 황소 오가닉모나스트렐 \uD83C\uDDEA\uD83C\uDDF8 ",
                nameEng = "Tussock Jumper, Bull Organic\nMonastrell, 2020",
                price = 44000,
                type = "레드",
                country = "스페인",
                alcoholContent = 17.0f,
                ml = 750,
                region = "후미야",
                imgRes = R.drawable.wine_sample_1
            ),
            WineList(
                name = "에스 쿠이코 오크드 샤도네이 \uD83C\uDDE8\uD83C\uDDF1",
                nameEng = "Es Cuiko Oaked Chardonnay, 2019",
                price = 65000,
                type = "화이트",
                country = "칠레",
                alcoholContent = 17.0f,
                ml = 750,
                region = "쿠리코 밸리",
                imgRes = R.drawable.wine_sample_2
            ),
            WineList(
                name = "스텔라 벨라, 카베르네 소비뇽 \uD83C\uDDE6\uD83C\uDDFA",
                nameEng = "Stella Bella, Cabernet Sauvignon,\n2017",
                price = 78000,
                type = "레드",
                country = "호주",
                alcoholContent = 19.0f,
                ml = 750,
                region = "마가렛 리버",
                imgRes = R.drawable.wine_sample_3
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
                subtitle = "샤또 롱보, 리브잘트 앙브레 \uD83C\uDDEB\uD83C\uDDF7",
                price = 69000,
                type = "주정강화",
                country = "프랑스",
                alcoholContent = 16.0f,
                ml = 500,
                region = "랑그독 루씨용",
                imgRes = R.drawable.other_sample_1
            ),
            WineListVertical(
                title = "극강의 부드러움",
                subtitle = "포르투 발도우로, 10년 숙성 포트 \uD83C\uDDF5\uD83C\uDDF9",
                price = 73000,
                type = "주정강화",
                country = "포르투갈",
                alcoholContent = 20.0f,
                ml = 750,
                region = "도우루",
                imgRes = R.drawable.other_sample_2
            )
        )
    }
}
