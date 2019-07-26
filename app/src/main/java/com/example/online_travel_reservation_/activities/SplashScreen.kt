package com.example.online_travel_reservation_.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.online_travel_reservation_.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {

    var SPLASH_TIME:Long=4000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        var myfadein: Animation = AnimationUtils.loadAnimation(this,
            R.anim.fadein
        )
        splash_image.startAnimation(myfadein)

        var myRunnable=object:Runnable{
            override fun run() {
                val i = Intent(this@SplashScreen, LoginActivity::class.java)
                startActivity(i)
                finish()

            }

        }

        Handler().postDelayed(myRunnable,SPLASH_TIME)
    }
}
