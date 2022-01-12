package com.agungs.consumerfavorite

import android.database.ContentObserver
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.agungs.consumerfavorite.databinding.ActivityMainBinding
import com.agungs.consumerfavorite.db.DatabaseContract.UserColumns.Companion.CONTENT_URI
import com.agungs.consumerfavorite.helper.MappingHelper
import com.agungs.consumerfavorite.model.Users
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvUserGithub: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Consumer Favorite"

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvUserGithub = findViewById(R.id.rv_userfavorite)
        rvUserGithub.setHasFixedSize(true)

        val handlerThread = HandlerThread("DataObserver")
        handlerThread.start()
        val handler = Handler(handlerThread.looper)

        val myObserver = object : ContentObserver(handler) {
            override fun onChange(self: Boolean) {
                loadUsersAsync()
            }
        }

        contentResolver.registerContentObserver(CONTENT_URI, true, myObserver)

        loadUsersAsync()
    }

    private fun loadUsersAsync() {
        GlobalScope.launch(Dispatchers.Main) {
            binding.progressBar.visibility = View.VISIBLE
            val deferredUsers = async(Dispatchers.IO) {
                val cursor = contentResolver?.query(CONTENT_URI, null, null, null, null)
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
                Toast.makeText(this@MainActivity, "user", Toast.LENGTH_SHORT).show()
            }
        })
    }
}