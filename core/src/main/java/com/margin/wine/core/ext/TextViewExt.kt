package com.margin.wine.core.ext

import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.TextView


fun TextView.addUnderline() {
    text = SpannableString(text).also { spannable ->
        spannable.setSpan(UnderlineSpan(), 0, text.length, 0)
    }
}