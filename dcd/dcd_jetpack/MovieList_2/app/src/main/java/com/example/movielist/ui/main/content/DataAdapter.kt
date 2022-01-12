package com.example.movielist.ui.main.content

import com.example.movielist.R
import com.example.movielist.data.ModelData
import com.example.movielist.utils.Helper.API_IMAGE_ENDPOINT
import com.example.movielist.utils.Helper.ENDPOINT_POSTER_SIZE_W185
import com.example.movielist.utils.Helper.setImageWithGlide
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_data.view.*

class DataAdapter(private val callback: DataCallback) :
    RecyclerView.Adapter<DataAdapter.ListViewHolder>() {
    private val listData = ArrayList<ModelData>()

    fun setData(data: List<ModelData>?) {
        if (data == null) return
        listData.clear()
        listData.addAll(data)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: ModelData) {
            with(itemView) {
                data.poster?.let {
                    setImageWithGlide(context, API_IMAGE_ENDPOINT+ ENDPOINT_POSTER_SIZE_W185 + it, img_data)
                }
                tv_data_title.text = data.name
                tv_data_desc.text = data.desc
                card_item.setOnClickListener {
                    callback.onItemClicked(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        )
    override fun getItemCount(): Int = listData.size
    override fun onBindViewHolder(holder: DataAdapter.ListViewHolder, position: Int) {
        holder.bind(listData[position])
    }
}