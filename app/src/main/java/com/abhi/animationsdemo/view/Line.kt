package com.abhi.animationsdemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.RelativeLayout
import androidx.core.view.marginLeft
import com.abhi.animationsdemo.R

class Line(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val paint: Paint
    var pointEndX: Float = 0f
    var pointEndY: Float = 0f
    var pointStartX: Float = 0f
    var pointStartY: Float = 0f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawLine(0f, 0f, 0f, pointEndY, paint)
    }

    init {
//        val params = RelativeLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
//        params.addRule(RelativeLayout.CENTER_IN_PARENT)
//        layoutParams = params
        val strokeWidth = 16f
        paint = Paint()
        paint.setAntiAlias(true)
        paint.setStyle(Paint.Style.STROKE)
        paint.setStrokeWidth(strokeWidth)
        //Circle color
        paint.setColor(resources.getColor(R.color.colorPrimary))

        //size 200x200 example
        //Initial Angle (optional, it can be zero)

    }

}