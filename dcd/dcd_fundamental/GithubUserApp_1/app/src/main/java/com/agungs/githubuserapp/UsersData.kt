package com.agungs.githubuserapp

import com.agungs.githubuserapp.model.Users
import android.content.Context
import android.content.res.Resources

object UsersData {
    private val usersUsername = Resources.getSystem().getStringArray(R.array.username).toList()
    private val usersName = Resources.getSystem().getStringArray(R.array.name).toList()
    private val usersLocation = Resources.getSystem().getStringArray(R.array.location).toList()
    private val usersRepository = Resources.getSystem().getStringArray(R.array.repository).toList()
    private val usersCompany = Resources.getSystem().getStringArray(R.array.company).toList()
    private val usersFollowers = Resources.getSystem().getStringArray(R.array.followers).toList()
    private val usersFollowing = Resources.getSystem().getStringArray(R.array.following).toList()
    private val usersAvatar = Resources.getSystem().getStringArray(R.array.avatar).toList()
//    private val usersUsername = arrayOf("aa")
//    private val usersName = arrayOf("aa")
//    private val usersLocation = arrayOf("aa")
//    private val usersRepository = arrayOf("aa")
//    private val usersCompany = arrayOf("aa")
//    private val usersFollowers = arrayOf("aa")
//    private val usersFollowing = arrayOf("aa")
//    private val usersAvatar = arrayOf("@drawable/user1")

    val listData: ArrayList<Users>
    get() {
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
    }
}