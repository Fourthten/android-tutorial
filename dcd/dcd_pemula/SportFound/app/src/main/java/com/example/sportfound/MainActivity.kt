package com.example.sportfound

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvSportHall: RecyclerView
    private var list: ArrayList<SportHall> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Gelanggang Olahraga"

        rvSportHall = findViewById(R.id.rv_sporthall)
        rvSportHall.setHasFixedSize(true)

        list.addAll(SportHallData.listData)
        showSportRecycleList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.profile, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val moveProfile = Intent(this@MainActivity, ProfileUser::class.java)
        startActivity(moveProfile)
        return super.onOptionsItemSelected(item)
    }

    private fun showSportRecycleList() {
        rvSportHall.layoutManager = LinearLayoutManager(this)
        val listSportHallAdapter = ListSportHallAdapter(list)
        rvSportHall.adapter = listSportHallAdapter

        listSportHallAdapter.setOnItemClickCallback(object : ListSportHallAdapter.OnItemClickCallback {
            override fun onItemClicked(data: SportHall) {
                showSelectedSportHall(data)
            }
        })
    }

    private fun showSelectedSportHall(sporthall: SportHall) {
        val moveDetailSportHall = Intent(this@MainActivity, DetailSportHall::class.java)
        moveDetailSportHall.putExtra(DetailSportHall.EXTRA_NAME, sporthall.name)
        moveDetailSportHall.putExtra(DetailSportHall.EXTRA_LOCATION, sporthall.location)
        moveDetailSportHall.putExtra(DetailSportHall.EXTRA_IMAGE, sporthall.image)
        moveDetailSportHall.putExtra(DetailSportHall.EXTRA_TIME, sporthall.time)
        moveDetailSportHall.putExtra(DetailSportHall.EXTRA_DAY, sporthall.day)
        startActivity(moveDetailSportHall)
    }
}