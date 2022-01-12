package com.agungs.githubuserapp

import android.content.ContentValues
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.agungs.githubuserapp.databinding.ActivityDetailUsersBinding
import com.agungs.githubuserapp.db.DatabaseContract
import com.agungs.githubuserapp.db.UserHelper
import com.agungs.githubuserapp.helper.MappingHelper
import com.agungs.githubuserapp.model.Users
import com.google.android.material.tabs.TabLayout
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.squareup.picasso.Picasso
import cz.msebera.android.httpclient.Header
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.json.JSONObject

class DetailUsers : AppCompatActivity() {
    private lateinit var binding: ActivityDetailUsersBinding
    private lateinit var userHelper: UserHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail_users)

        supportActionBar?.title = "Detail Users"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding = ActivityDetailUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userHelper = UserHelper.getInstance(applicationContext)
        userHelper.open()

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

        if (detailusers != null) {
            loadUserssAsync(detailusers)
        }

        val fab: View = findViewById(R.id.fab_favorites)

        fab.setOnClickListener { view ->
            if (detailusers != null) {
                loadUserAsync(detailusers)
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
                    users.location = jsonObject.getString("location")
                    users.email = jsonObject.getString("email")

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
        val pages = intent.getStringExtra("pages")
        if(pages == "favorite"){
            val moveFavorites = Intent(this@DetailUsers, FavoriteUsers::class.java)
            startActivity(moveFavorites)
            return true
        } else {
            onBackPressed()
            return true
        }
    }

    private fun addFavorite(username: String) {
        val values = ContentValues()
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
                    users.followers = jsonObject.getString("followers_url")
                    users.following = jsonObject.getString("following_url")
                    users.type = jsonObject.getString("type")
                    users.avatar = jsonObject.getString("avatar_url")
                    users.email = jsonObject.getString("email")
                    users.location = jsonObject.getString("location")
                    users.company = jsonObject.getString("company")

                    values.put(DatabaseContract.UserColumns._ID, users.id)
                    values.put(DatabaseContract.UserColumns.USERNAME, users.username)
                    values.put(DatabaseContract.UserColumns.FOLLOWERS, users.followers)
                    values.put(DatabaseContract.UserColumns.FOLLOWING, users.following)
                    values.put(DatabaseContract.UserColumns.TYPE, users.type)
                    values.put(DatabaseContract.UserColumns.AVATAR, users.avatar)
                    values.put(DatabaseContract.UserColumns.EMAIL, users.email)
                    values.put(DatabaseContract.UserColumns.LOCATION, users.location)
                    values.put(DatabaseContract.UserColumns.COMPANY, users.company)

                    val result = userHelper.insert(values)
                    changeFloating()
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

    private fun loadUserssAsync(detailusers:Users) {
        GlobalScope.launch(Dispatchers.Main) {
            binding.progressBar.visibility = View.VISIBLE
            val deferredUsers = async(Dispatchers.IO) {
                val cursor = detailusers?.id?.let { userHelper.queryById(it.toString()) }
                MappingHelper.mapCursorToDetail(cursor)
            }
            binding.progressBar.visibility = View.INVISIBLE
            val users = deferredUsers.await()
            val fab: View = findViewById(R.id.fab_favorites)
            if (users.id != 0) {
                changeFloating()
            } else {
                changeFloatingtrue()
            }
        }
    }

    private fun loadUserAsync(detailusers:Users) {
        GlobalScope.launch(Dispatchers.Main) {
            binding.progressBar.visibility = View.VISIBLE
            val deferredUsers = async(Dispatchers.IO) {
                val cursor = detailusers?.id?.let { userHelper.queryById(it.toString()) }
                MappingHelper.mapCursorToDetail(cursor)
            }
            binding.progressBar.visibility = View.INVISIBLE
            val users = deferredUsers.await()
            val fab: View = findViewById(R.id.fab_favorites)
            if (users.id != 0) {
                val result = detailusers?.id?.let { userHelper.deleteById(it.toString()) }
                changeFloatingtrue()
            } else {
                detailusers?.username.let {
                    if (it != null) {
                        addFavorite(it)
                    }
                }
            }
        }
    }

    private fun changeFloating(){
        val fabs: FloatingActionButton = findViewById(R.id.fab_favorites)
        val fab: View = findViewById(R.id.fab_favorites)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            fabs.setImageDrawable(getResources().getDrawable(R.drawable.favorite, this@DetailUsers.getTheme()));
        } else {
            fabs.setImageDrawable(getResources().getDrawable(R.drawable.favorite));
        }

        fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#3700B3")));
    }

    private fun changeFloatingtrue(){
        val fabs: FloatingActionButton = findViewById(R.id.fab_favorites)
        val fab: View = findViewById(R.id.fab_favorites)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            fabs.setImageDrawable(getResources().getDrawable(R.drawable.unfavorite, this@DetailUsers.getTheme()));
        } else {
            fabs.setImageDrawable(getResources().getDrawable(R.drawable.unfavorite));
        }

        fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#03DAC5")));
    }
}