package com.agungs.githubuserapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.agungs.githubuserapp.model.Users
import com.squareup.picasso.Picasso


class ListGithubUsers(private val listUsersGithub: ArrayList<Users>, val context: Context) : RecyclerView.Adapter<ListGithubUsers.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvUsername: TextView = itemView.findViewById(R.id.tv_usergithub_username)
        var tvName: TextView = itemView.findViewById(R.id.tv_usergithub_name)
        var imgImage: ImageView = itemView.findViewById(R.id.img_usergithub)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.activity_list_github_users, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listUsersGithub.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val users = listUsersGithub[position]
        Picasso.with(this.context).load(users.avatar).fit().into(holder.imgImage);

        holder.tvUsername.text = users.username
        holder.tvName.text = users.type

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listUsersGithub[holder.adapterPosition]) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Users)
    }
}