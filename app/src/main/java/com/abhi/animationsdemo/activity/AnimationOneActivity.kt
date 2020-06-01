package com.abhi.animationsdemo.activity

import android.graphics.*
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.animation.Animation
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.abhi.animationsdemo.R
import com.abhi.animationsdemo.view.Circle
import com.abhi.animationsdemo.view.CircleAngleAnimation
import com.abhi.animationsdemo.view.Line
import com.abhi.animationsdemo.view.LineAnimation
import kotlinx.android.synthetic.main.activity_animation_one.*


class AnimationOneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_one)
        button.setOnClickListener {

            val circle = Circle(this, null, 90f)
            val params = RelativeLayout.LayoutParams(resources.getDimension(R.dimen.dp_34).toInt(), resources.getDimension(R.dimen.dp_34).toInt())
            params.addRule(RelativeLayout.CENTER_IN_PARENT)
            circle.id

            relativeLayuot.addView(circle, params)
            val animation = CircleAngleAnimation(circle, 360)
            animation.duration = 1000
            circle.startAnimation(animation)
            animation.setAnimationListener(object : Animation.AnimationListener{
                override fun onAnimationRepeat(p0: Animation?) {
                }

                override fun onAnimationEnd(p0: Animation?) {

                    val line = Line(this@AnimationOneActivity, null)
                    val rectf = Rect()
                    circle.getLocalVisibleRect(rectf)
                    val params1 = RelativeLayout.LayoutParams(resources.getDimension(R.dimen.dp_2).toInt(), WRAP_CONTENT)
                    params1.leftMargin = (circle.x + rectf.right/2).toInt() -2
                    params1.topMargin = (circle.y + rectf.bottom).toInt() - 4

//                    line.x = (circle.x + rectf.right/2)
//                    line.y = (circle.y + rectf.bottom/2)


                    relativeLayuot.addView(line, params1)


                    val animation1 = LineAnimation(line, 40f, circle)
                    animation1.duration = 1000
                    line.startAnimation(animation1)
                    animation1.setAnimationListener(object : Animation.AnimationListener{
                        override fun onAnimationRepeat(p0: Animation?) {

                        }

                        override fun onAnimationEnd(p0: Animation?) {
                            val circled = Circle(this@AnimationOneActivity, null, 270f)
                            val params = RelativeLayout.LayoutParams(resources.getDimension(R.dimen.dp_34).toInt(), resources.getDimension(R.dimen.dp_34).toInt())
                            params.addRule(RelativeLayout.CENTER_HORIZONTAL)
//                            params.addRule(RelativeLayout.BELOW, line.id)
//                            params.addRule(RelativeLayout.ABOVE, line.id)
                            params.topMargin = 1020

                            relativeLayuot.addView(circled, params)
                            val animation = CircleAngleAnimation(circled, 360)
                            animation.duration = 1000
                            circled.startAnimation(animation)
                            animation.setAnimationListener(object : Animation.AnimationListener {
                                override fun onAnimationRepeat(p0: Animation?) {

                                }

                                override fun onAnimationEnd(p0: Animation?) {
                                    val line = Line(this@AnimationOneActivity, null)
                                    val rectf = Rect()
                                    circled.getLocalVisibleRect(rectf)
                                    val params1 = RelativeLayout.LayoutParams(resources.getDimension(R.dimen.dp_2).toInt(), WRAP_CONTENT)
                                    params1.leftMargin = (circled.x + rectf.right/2).toInt() -2
                                    params1.topMargin = (circled.y + rectf.bottom).toInt() - 4

//                    line.x = (circle.x + rectf.right/2)
//                    line.y = (circle.y + rectf.bottom/2)


                                    relativeLayuot.addView(line, params1)


                                    val animation1 = LineAnimation(line, 40f, circled)
                                    animation1.duration = 1000
                                    line.startAnimation(animation1)

                                }

                                override fun onAnimationStart(p0: Animation?) {
                                }

                            })
                        }

                        override fun onAnimationStart(p0: Animation?) {
                        }

                    })
                }

                override fun onAnimationStart(p0: Animation?) {

                }

            })
        }
    }
}