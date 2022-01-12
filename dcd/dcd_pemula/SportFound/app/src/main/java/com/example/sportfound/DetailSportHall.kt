package com.example.sportfound

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailSportHall : AppCompatActivity() {
    companion object {
        const val EXTRA_NAME = "name"
        const val EXTRA_LOCATION = "location"
        const val EXTRA_IMAGE = "image"
        const val EXTRA_TIME = "time"
        const val EXTRA_DAY = "day"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_sport_hall)

        supportActionBar?.title = "Detail GOR"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var tvName: TextView = findViewById(R.id.tv_sporthall_name)
        var tvLocation: TextView = findViewById(R.id.tv_sporthall_location)
        var imgImage: ImageView = findViewById(R.id.img_sporthall)
        var tvTime: TextView = findViewById(R.id.tv_sporthall_time)
        var tvDay: TextView = findViewById(R.id.tv_sporthall_day)

        val name = intent.getStringExtra(EXTRA_NAME)
        val location = intent.getStringExtra(EXTRA_LOCATION)
        val image = intent.getIntExtra(EXTRA_IMAGE, R.mipmap.ic_launcher)
        val time = intent.getStringExtra(EXTRA_TIME)
        val day = intent.getStringExtra(EXTRA_DAY)

        tvName.text = name
        tvLocation.text = location
        imgImage.setImageResource(image)
        tvTime.text = "Jam : $time"
        tvDay.text = "Hari : $day"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}