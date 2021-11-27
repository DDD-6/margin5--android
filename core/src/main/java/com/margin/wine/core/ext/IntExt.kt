package com.margin.wine.core.ext

import java.text.NumberFormat
import java.util.*

fun Int.won(): String {
    return NumberFormat.getInstance(Locale.KOREA).format(this) + "원"
}