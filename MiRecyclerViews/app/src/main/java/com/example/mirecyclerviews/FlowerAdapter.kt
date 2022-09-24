package com.example.mirecyclerviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FlowerAdapter(dataSource: Array<String>) : RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder>() {
    class FlowerViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val txt : TextView // = view.findViewById(R.id.flower_text)
        init {
            txt = view.findViewById(R.id.flower_text)
        }

//        constructor() : this() {
//
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        var layout_ite = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_flower, parent, false)

        return FlowerViewHolder(layout_ite)
    }

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}