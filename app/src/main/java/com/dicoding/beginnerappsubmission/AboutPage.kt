package com.dicoding.beginnerappsubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AboutPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_page)

        val actionBar = supportActionBar
        actionBar?.hide()
    }
}