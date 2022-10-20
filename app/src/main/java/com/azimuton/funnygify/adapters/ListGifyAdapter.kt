package com.azimuton.funnygify.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.azimuton.data.models.Data
import com.azimuton.data.models.Gify
import com.azimuton.funnygify.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*

class ListGifyAdapter(val contextA: Context, val listGify: List<Data>?)
    : RecyclerView.Adapter<ListGifyAdapter.ViewHolder>() {
    class ViewHolder(itemView : View, contextV: Context)  : RecyclerView.ViewHolder(itemView) {
        fun bind(listItem: Gify) {
            itemView.setOnClickListener {

            }
        }

        val context = contextV
        var title: TextView? = null
        var image : ImageView? = null

        init{
            title = itemView.tvTitleItem
            image  = itemView.ivItemImage

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(contextA).inflate(R.layout.item_list, parent, false), contextA)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = listGify?.get(position)
//        Picasso.with(contextA)
//            .load(listGify?.get(position)?.images?.original?.url)
//            .into(holder.image)
        Glide.with(contextA)
            .asGif()
            .load(listGify?.get(position)?.images?.original?.url)
            .into(holder.image!!)
        holder.title?.text = listItem?.title
    }

    override fun getItemCount(): Int {
       return listGify!!.size
    }

}