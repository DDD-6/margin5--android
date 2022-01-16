package com.margin.wine.sign.step

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import com.margin.wine.sign.R

@SuppressLint("UseCompatLoadingForDrawables")
class SignBottomButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatButton(context, attrs) {

    fun enabled(enable: Boolean) {
        if (enable) {
            background = resources.getDrawable(R.drawable.bg_btn_focus_on, null)
            setTextColor(Color.WHITE)
        } else {
            background = resources.getDrawable(R.drawable.bg_btn_focus_off, null)
            setTextColor(context.getColor(R.color.color_9D9D9D))
        }
    }

}