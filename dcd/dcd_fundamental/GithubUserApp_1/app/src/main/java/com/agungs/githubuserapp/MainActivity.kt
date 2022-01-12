package com.agungs.githubuserapp

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.agungs.githubuserapp.model.Users

class MainActivity : AppCompatActivity() {
    private lateinit var rvUserGithub: RecyclerView
    private var list: ArrayList<Users> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "List Users"

        rvUserGithub = findViewById(R.id.rv_usergithub)
        rvUserGithub.setHasFixedSize(true)

        list.addAll(getData())
        showUsersRecycleList()
    }

    private fun showUsersRecycleList() {
        rvUserGithub.layoutManager = LinearLayoutManager(this)
        val listUsersAdapter = ListGithubUsers(list, this)
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

    fun getData(): ArrayList<Users> {
        val usersUsername = resources.getStringArray(R.array.username).toList()
        val usersName = resources.getStringArray(R.array.name).toList()
        val usersLocation = resources.getStringArray(R.array.location).toList()
        val usersRepository = resources.getStringArray(R.array.repository).toList()
        val usersCompany = resources.getStringArray(R.array.company).toList()
        val usersFollowers = resources.getStringArray(R.array.followers).toList()
        val usersFollowing = resources.getStringArray(R.array.following).toList()
        val usersAvatar = resources.getStringArray(R.array.avatar).toList()
//        val listData: ArrayList<Users>
//        get() {
            val list = arrayListOf<Users>()
            for (position in usersUsername.indices) {
                val users = Users()
                users.username = usersUsername[position]
                users.name = usersName[position]
                users.location = usersLocation[position]
                users.repository = usersRepository[position]
                users.company = usersCompany[position]
                users.followers = usersFollowers[position]
                users.following = usersFollowing[position]
                users.avatar = usersAvatar[position]
                list.add(users)
            }
            return list
//        }
    }
}