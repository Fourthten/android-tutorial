package com.agungs.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.agungs.githubuserapp.model.Users

class DetailUsers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_users)

        supportActionBar?.title = "Detail Users"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var tvUsername: TextView = findViewById(R.id.tv_users_username)
        var tvName: TextView = findViewById(R.id.tv_users_name)
        var tvLocation: TextView = findViewById(R.id.tv_users_location)
        var tvRepository: TextView = findViewById(R.id.tv_users_repository)
        var tvCompany: TextView = findViewById(R.id.tv_users_company)
        var tvFollowers: TextView = findViewById(R.id.tv_users_followers)
        var tvFollowing: TextView = findViewById(R.id.tv_users_following)
        var ivAvatar: ImageView = findViewById(R.id.img_users)

        val detailusers = intent.getParcelableExtra<Users>("detailuser")

        tvUsername.text = detailusers?.username
        tvName.text = detailusers?.name
        tvLocation.text = detailusers?.location
        tvRepository.text = detailusers?.repository
        tvCompany.text = detailusers?.company
        tvFollowers.text = detailusers?.followers
        tvFollowing.text = detailusers?.following

        val imgrep1 = detailusers?.avatar?.replace("res/drawable","@drawable")
        val imgrep2 = imgrep1?.replace(".png","")
        val uri = imgrep2
        val imageResource: Int = resources.getIdentifier(uri, null, getPackageName())
        ivAvatar.setBackgroundResource(imageResource)
//        val uri = detailusers?.avatar
//        val imageResource: Int = resources.getIdentifier(uri, null, getPackageName())
//        ivAvatar.setBackgroundResource(imageResource)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}