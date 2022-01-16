package com.margin.wine.core.view

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import android.graphics.Paint
import android.util.AttributeSet
import android.graphics.Paint.FontMetricsInt
import android.graphics.Canvas
import android.text.TextUtils
import android.util.Log

class UnderlineTextView : AppCompatTextView {
    private var mLinePaint: Paint? = null
    private var mSpaceHeight = 0
    private val mAddHeight = 0

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(context)
    }

    private fun init(context: Context) {
        includeFontPadding = false
        mLinePaint = Paint()
        mLinePaint!!.strokeWidth = textSize / 18
        mLinePaint!!.color = textColors.defaultColor
        val fontMetricsInt = paint.fontMetricsInt
        mSpaceHeight =
            Math.abs(fontMetricsInt.bottom - fontMetricsInt.ascent - lineHeight) - (fontMetricsInt.bottom
                    - fontMetricsInt.descent)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (TextUtils.isEmpty(text)) {
            return
        }
        val lineCount = lineCount
        val layout = layout
        val paddingTop = paddingTop
        val paddingLeft = paddingLeft
        Log.d("UnderLineTextView", lineCount.toString())
        for (i in 0 until lineCount) {
            val currentXStart = layout.getLineLeft(i) + paddingLeft
            val currentXEnd = layout.getLineRight(i) + paddingLeft
            Log.d("UnderLineTextView", layout.getLineBottom(i).toString())
            Log.d("UnderLineTextView", paddingTop.toString())
            Log.d("UnderLineTextView", mSpaceHeight.toString())
            val currentY = layout.getLineBottom(i) + paddingTop + mSpaceHeight + mAddHeight + if(i == lineCount-1) 37 else 0
            canvas.drawLine(
                currentXStart,
                currentY.toFloat(),
                currentXEnd,
                currentY.toFloat(),
                mLinePaint!!
            )
        }
    }

    fun setLineWeight(value: Float) {
        mLinePaint!!.strokeWidth = value
    }

    fun setLineColor(color: Int) {
        mLinePaint!!.color = color
    }

    fun addSpaceHeight(value: Int) {
        //mAddHeight = value;
    }
}