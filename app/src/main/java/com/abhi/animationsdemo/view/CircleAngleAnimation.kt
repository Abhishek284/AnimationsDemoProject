package com.abhi.animationsdemo.view

import android.view.animation.Animation
import android.view.animation.Transformation


class CircleAngleAnimation(circle: Circle, newAngle: Int) : Animation() {
    private val circle: Circle
    private val oldAngle: Float
    private val newAngle: Float

    override fun applyTransformation(
        interpolatedTime: Float,
        transformation: Transformation?
    ) {
        val angle = oldAngle + (newAngle - oldAngle) * interpolatedTime
        circle.angle = angle
        circle.requestLayout()
    }

    init {
        oldAngle = circle.angle
        this.newAngle = newAngle.toFloat()
        this.circle = circle
    }
}