package com.dicoding.beginnerappsubmission

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val actionBar = supportActionBar
        actionBar?.hide()

        Handler().postDelayed({
            startActivity(Intent(this@SplashScreen,MainActivity::class.java))
            finish()
        }, 1000)
    }
}