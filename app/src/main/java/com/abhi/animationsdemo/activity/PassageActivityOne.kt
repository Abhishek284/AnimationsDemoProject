package com.abhi.animationsdemo.activity

import android.content.Intent
import android.os.Bundle
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.abhi.animationsdemo.R
import kotlinx.android.synthetic.main.activity_passage_one.*


class PassageActivityOne : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_passage_one)
        mario.setOnClickListener {
            val activityOptionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this, mario, "TestTrans")
            val intent: Intent = Intent(
                this,
                PassageTwoActivity::class.java
            )
            startActivity(intent, activityOptionsCompat.toBundle())
        }
    }
}
