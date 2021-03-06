package com.application.defacto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    private val splashTime: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        Handler(mainLooper).postDelayed({
            val splashIntent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(splashIntent)
            finish()
        }, splashTime)
    }
}