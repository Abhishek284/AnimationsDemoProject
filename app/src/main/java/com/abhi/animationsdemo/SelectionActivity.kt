package com.abhi.animationsdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abhi.animationsdemo.activity.AnimationOneActivity
import com.abhi.animationsdemo.activity.PhysicsAnimationActivity
import kotlinx.android.synthetic.main.activity_selection.*

class SelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)
        viewPagerAnimation.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        objectAnimation.setOnClickListener {
            startActivity(Intent(this, TransistionActivity::class.java))
        }

        basicAnimation.setOnClickListener {
            startActivity(Intent(this, BasicAnimation::class.java))
        }
        physicsAnimation.setOnClickListener {
            startActivity(Intent(this, PhysicsAnimationActivity::class.java))
        }
        animationOne.setOnClickListener {
            startActivity(Intent(this, AnimationOneActivity::class.java))
        }
    }
}