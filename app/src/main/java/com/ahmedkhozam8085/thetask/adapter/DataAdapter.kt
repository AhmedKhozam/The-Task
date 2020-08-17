package com.ahmedkhozam8085.thetask.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ahmedkhozam8085.thetask.R
import com.ahmedkhozam8085.thetask.adapter.DataAdapter.PopularViewHolder
import com.ahmedkhozam8085.thetask.model.home.DataItem
import com.ahmedkhozam8085.thetask.view.Detail.Details
import com.bumptech.glide.Glide

class DataAdapter(private val context: Context, private val dataItemList: List<DataItem>) : RecyclerView.Adapter<PopularViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false)
        return PopularViewHolder(view)
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        Glide.with(context).load(dataItemList[position].image).into(holder.image)
        holder.itemView.setOnClickListener { view: View? ->
            val i = Intent(context, Details::class.java)
            i.putExtra("image", dataItemList[position].image)
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return dataItemList.size
    }

    class PopularViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView

        init {
            image = itemView.findViewById(R.id.personImage)
        }
    }

}