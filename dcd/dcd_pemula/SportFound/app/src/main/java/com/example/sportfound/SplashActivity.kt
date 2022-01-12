package com.example.sportfound

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val splashIntent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(splashIntent)
            finish()
        }, 5000)
    }
}