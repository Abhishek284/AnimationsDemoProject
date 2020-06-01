package com.abhi.animationsdemo.view

import android.R
import android.graphics.Rect
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_animation_one.*


class LineAnimation(line: Line, private val point: Float, private var circle: Circle) : Animation() {

    private val line: Line

    override fun applyTransformation(
        interpolatedTime: Float,
        transformation: Transformation?
    ) {
        val rectf = Rect()
        circle.getLocalVisibleRect(rectf)
        line.pointStartX = (circle.x + rectf.right/2) * interpolatedTime
        line.pointStartY = (circle.y + rectf.bottom/2) * interpolatedTime
        line.pointEndX = line.pointStartX
        line.pointEndY = (80) * interpolatedTime

//        line.x = line.pointStartX
//        line.y = line.pointStartY
        line.requestLayout()
    }


    init {
        this.line = line
    }

}