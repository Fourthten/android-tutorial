package com.agungs.githubuserapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.agungs.githubuserapp.databinding.ActivityFavoriteUsersBinding
import com.agungs.githubuserapp.db.UserHelper
import com.agungs.githubuserapp.helper.MappingHelper
import com.agungs.githubuserapp.model.Users
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class FavoriteUsers : AppCompatActivity() {
    private lateinit var userHelper: UserHelper
    private lateinit var binding: ActivityFavoriteUsersBinding
    private lateinit var rvUserGithub: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Favorites"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        userHelper = UserHelper.getInstance(applicationContext)
        userHelper.open()

        rvUserGithub = findViewById(R.id.rv_userfavorite)
        rvUserGithub.setHasFixedSize(true)

        loadUserssAsync()
    }

    private fun loadUserssAsync() {
        GlobalScope.launch(Dispatchers.Main) {
            binding.progressBar.visibility = View.VISIBLE
            val deferredUsers = async(Dispatchers.IO) {
                val cursor = userHelper.queryAll()
                MappingHelper.mapCursorToArrayList(cursor)
            }
            binding.progressBar.visibility = View.INVISIBLE
            val users = deferredUsers.await()
            if (users.size > 0) {
                showUsersRecycleList(users)
            }
        }
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
        val moveDetailUsers = Intent(this@FavoriteUsers, DetailUsers::class.java)
        moveDetailUsers.putExtra("detailuser", users)
        moveDetailUsers.putExtra("pages", "favorite")
        startActivity(moveDetailUsers)
    }

    override fun onDestroy() {
        super.onDestroy()
        userHelper.close()
    }

    override fun onSupportNavigateUp(): Boolean {
        val moveFavorites = Intent(this@FavoriteUsers, MainActivity::class.java)
        startActivity(moveFavorites)
        return true
    }
}