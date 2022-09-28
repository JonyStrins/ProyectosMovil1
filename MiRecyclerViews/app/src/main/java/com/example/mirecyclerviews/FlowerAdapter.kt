package com.example.mirecyclerviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mirecyclerviews.data.Flower

class FlowerAdapter(dataSource: List<Flower>) : RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder>() {
    class FlowerViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val txt : TextView // = view.findViewById(R.id.flower_text)
        val img: ImageView
        init {
            txt = view.findViewById(R.id.flower_text)
            img = view.findViewById(R.id.flower_image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        var layout_ite = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_flower_custom, parent, false)
        return FlowerViewHolder(layout_ite)
    }

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        holder.txt.text = datasource[position].name
        datasource[position].image?.let{ holder.img.setImageResource(it) }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}