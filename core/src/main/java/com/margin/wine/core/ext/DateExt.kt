package com.margin.wine.core.ext

import java.text.SimpleDateFormat
import java.util.*

fun currentDate(): String {
    return SimpleDateFormat("yyyy/MM/dd/E", Locale.KOREA).format(Date())
}