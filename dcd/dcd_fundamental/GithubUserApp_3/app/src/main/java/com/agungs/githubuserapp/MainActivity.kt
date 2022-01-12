package com.agungs.githubuserapp

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.agungs.githubuserapp.databinding.ActivityMainBinding
import com.agungs.githubuserapp.db.UserHelper
import com.agungs.githubuserapp.model.Users
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray
import org.json.JSONObject
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var userHelper: UserHelper

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    private lateinit var rvUserGithub: RecyclerView
    private lateinit var searchView: SearchView
    private var list: ArrayList<Users> = arrayListOf()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Github User API"

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvUserGithub = findViewById(R.id.rv_usergithub)
        rvUserGithub.setHasFixedSize(true)

        userHelper = UserHelper.getInstance(applicationContext)
        userHelper.open()

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = findViewById(R.id.search)

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.search_hint)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                val urlFind = "https://api.github.com/search/users?q=$query"
                getUserData(urlFind, "search")
                return true
            }
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
        searchView.setOnCloseListener {
            getUserData("https://api.github.com/users", "all")
            true
        }

        getUserData("https://api.github.com/users", "all")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()
        if (id == R.id.menu_icon) {
            val moveFavorites = Intent(this@MainActivity, FavoriteUsers::class.java)
            startActivity(moveFavorites)
            return true
        }
        if (id == R.id.setting_icon) {
            val moveSettings = Intent(this@MainActivity, SettingAlarm::class.java)
            startActivity(moveSettings)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getUserData(urlParams: String, type: String) {
        binding.progressBar.visibility = View.VISIBLE
        val client = AsyncHttpClient()
        val url = urlParams
        client.addHeader("Authorization", "token a34095d192ec6f637bc5aaace01a4cd0342978e3");
        client.addHeader("User-Agent", "request");
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {
                binding.progressBar.visibility = View.INVISIBLE
                var result = String(responseBody)
                try {
                    var jsonArray = JSONArray()
                    if(type=="search"){
                        val responseObject = JSONObject(result)
                        jsonArray = responseObject.getJSONArray("items")
                    } else {
                        jsonArray = JSONArray(result)
                    }
                    list = arrayListOf<Users>()
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        val users = Users()
                        users.id = jsonObject.getInt("id")
                        users.username = jsonObject.getString("login")
                        users.followers = jsonObject.getString("followers_url")
                        users.following = jsonObject.getString("following_url")
                        users.type = jsonObject.getString("type")
                        users.avatar = jsonObject.getString("avatar_url")
                        list.add(users)
                    }
                    showUsersRecycleList(list)
                } catch (e: Exception) {
                    Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
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
                Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun showUsersRecycleList(lists :ArrayList<Users>) {
        rvUserGithub.layoutManager = LinearLayoutManager(this)
        val listUsersAdapter = ListGithubUsers(lists, this)
        rvUserGithub.adapter = listUsersAdapter

        listUsersAdapter.setOnItemClickCallback(object : ListGithubUsers.OnItemClickCallback {
            override fun onItemClicked(data: Users) {
                showSelectedUsers(data)
            }
        })
    }

    private fun showSelectedUsers(users: Users) {
        val moveDetailUsers = Intent(this@MainActivity, DetailUsers::class.java)
        moveDetailUsers.putExtra("detailuser", users)
        startActivity(moveDetailUsers)
    }
}