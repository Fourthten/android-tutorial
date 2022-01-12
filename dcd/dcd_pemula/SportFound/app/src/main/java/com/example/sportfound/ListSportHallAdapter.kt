package com.example.sportfound

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListSportHallAdapter(private val listSportHall: ArrayList<SportHall>) : RecyclerView.Adapter<ListSportHallAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_sporthall_name)
        var tvLocation: TextView = itemView.findViewById(R.id.tv_sporthall_location)
        var imgImage: ImageView = itemView.findViewById(R.id.img_sporthall)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_sport_hall, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listSportHall.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val sporthall = listSportHall[position]

        Glide.with(holder.itemView.context)
            .load(sporthall.image)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgImage)

        holder.tvName.text = sporthall.name
        holder.tvLocation.text = sporthall.location

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listSportHall[holder.adapterPosition]) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: SportHall)
    }
}