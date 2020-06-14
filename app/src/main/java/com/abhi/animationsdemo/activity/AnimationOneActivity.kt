package com.abhi.animationsdemo.activity

import android.graphics.*
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.animation.Animation
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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

                    val textView = TextView(this@AnimationOneActivity)
                    textView.text = "1"
                    textView.setTextColor(ContextCompat.getColor(this@AnimationOneActivity, R.color.colorPrimary))
                    val paramsText = RelativeLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
                    paramsText.addRule(RelativeLayout.CENTER_IN_PARENT)
                    textView.layoutParams = paramsText
                    relativeLayuot.addView(textView)


                    val line = Line(this@AnimationOneActivity, null)
                    line.id = R.id.btn_chained_spring
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

//                            params.addRule(RelativeLayout.BELOW, R.id.btn_chained_spring)
//                            circled.layoutParams = params
//                            params.addRule(RelativeLayout.ALIGN_PARENT_TOP, 0);

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

                                    val textView2 = TextView(this@AnimationOneActivity)
                                    textView2.text = "2"
                                    textView2.setTextColor(ContextCompat.getColor(this@AnimationOneActivity, R.color.colorPrimary))
                                    val paramsText2 = RelativeLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
                                    paramsText2.leftMargin = (circled.x + rectf.right/2).toInt() - 10
                                    paramsText2.topMargin = (circled.y + rectf.top).toInt() + 14
                                    textView2.layoutParams = paramsText2
                                    relativeLayuot.addView(textView2)



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