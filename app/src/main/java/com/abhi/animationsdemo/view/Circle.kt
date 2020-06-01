package com.abhi.animationsdemo.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.abhi.animationsdemo.R


class Circle(context: Context?, attrs: AttributeSet?, private val startPoint: Float) : View(context, attrs) {
    private val paint: Paint
    private val rect: RectF
    var angle: Float

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawArc(rect, startPoint, angle, false, paint)
    }

    companion object {
        private const val START_ANGLE_POINT = 90f
    }

    init {

        val strokeWidth = resources.getDimension(R.dimen.dp_2)
        paint = Paint()
        paint.setAntiAlias(true)
        paint.setStyle(Paint.Style.STROKE)
        paint.setStrokeWidth(strokeWidth)
        //Circle color
        paint.setColor(resources.getColor(R.color.colorPrimary))
        //size 200x200 example


        rect = RectF(
            strokeWidth.toFloat(),
            strokeWidth.toFloat(),
            (resources.getDimension(R.dimen.dp_30) + strokeWidth).toFloat(),
            (resources.getDimension(R.dimen.dp_30) + strokeWidth).toFloat()
        )
        //Initial Angle (optional, it can be zero)
        angle = 0f
    }

}