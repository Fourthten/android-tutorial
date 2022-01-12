package com.example.sportfound

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProfileUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_user)

        supportActionBar?.title = "Profil Pengguna"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}