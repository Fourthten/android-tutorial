package com.agungs.githubuserapp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.agungs.githubuserapp.databinding.ActivityDetailUsersBinding
import com.agungs.githubuserapp.model.Users
import com.google.android.material.tabs.TabLayout
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.squareup.picasso.Picasso
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class DetailUsers : AppCompatActivity() {
    private lateinit var binding: ActivityDetailUsersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail_users)

        supportActionBar?.title = "Detail Users"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding = ActivityDetailUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        supportActionBar?.elevation = 0f

        val detailusers = intent.getParcelableExtra<Users>("detailuser")

        detailusers?.username.let {
            if (it != null) {
                getUserData(it)
            }
        }
    }

    private fun getUserData(username: String) {
        var tvUsername: TextView = findViewById(R.id.tv_users_username)
        var tvEmail: TextView = findViewById(R.id.tv_users_email)
        var tvLocation: TextView = findViewById(R.id.tv_users_location)
        var ivAvatar: ImageView = findViewById(R.id.img_users)

        binding.progressBar.visibility = View.VISIBLE
        val client = AsyncHttpClient()
        val url = "https://api.github.com/users/$username"
        client.addHeader("Authorization", "token a34095d192ec6f637bc5aaace01a4cd0342978e3");
        client.addHeader("User-Agent", "request");
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {
                binding.progressBar.visibility = View.INVISIBLE
                var result = String(responseBody)
                try {
                    val jsonObject = JSONObject(result)
                    val users = Users()
                    users.id = jsonObject.getInt("id")
                    users.username = jsonObject.getString("login")
                    users.avatar = jsonObject.getString("avatar_url")

                    tvUsername.text = users.username
                    tvEmail.text = users.email
                    tvLocation.text = users.location
                    Picasso.with(this@DetailUsers).load(users.avatar).fit().into(ivAvatar);
                } catch (e: Exception) {
                    Toast.makeText(this@DetailUsers, e.message, Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }
            }
            override fun onFailure(statusCode: Int, headers: Array<Header>, responseBody: ByteArray, error: Throwable) {
                binding.progressBar.visibility = View.INVISIBLE
                val errorMessage = when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error.message}"
                }
                Toast.makeText(this@DetailUsers, errorMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}