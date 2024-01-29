package com.abhi.animationsdemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.abhi.animationsdemo.activity.*
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
        animationTwo.setOnClickListener {
            startActivity(Intent(this, AnimationTwoActivity::class.java))
        }
        animationThree.setOnClickListener {
            startActivity(Intent(this, AnimationThreeActivity::class.java))
        }
        animationFour.setOnClickListener {
            startActivity(Intent(this, PassageActivityOne::class.java))
        }
        var editText = findViewById<EditText>(R.id.editTextNew)
        editText.addTextChangedListener {
            if (it.toString().length == 15) {
                startActivity(Intent(this@SelectionActivity, AnimationOneActivity::class.java))
            }
            if(it.toString().length == 10) {
                var s = findNumberOfCharactersA(it.toString())
                Log.d("LARGEST", "Largest number of A's is $s")
            }
        }
    }

    private fun findNumberOfCharactersA(toString: String): Int {
        var count = 0
        var max = 0
        for (i in toString.indices) {
            if (toString[i] == 'a') {
                count++
            } else {
                if (count > max) {
                    max = count
                }
                count = 0
            }
        }
        return max

    }

    override fun onResume() {
        super.onResume()
    }
}