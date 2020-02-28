package com.zw.kotlin_android.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int)
    : View(context, attrs, defStyleAttr, defStyleRes) {
    var TAG = MyView::class.java.simpleName

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int)
            : this(context, attrs, defStyleAttr, 0) {

    }

    constructor(context: Context?, attrs: AttributeSet?)
            : this(context, attrs, 0, 0) {

    }

    constructor(context: Context?) : this(context, null, 0, 0) {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var paint = Paint()
        paint.color = Color.RED
        canvas?.drawCircle(100f, 100f, 50f, paint)
    }
}