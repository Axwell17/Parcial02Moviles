package com.example.parcial02.ui.mountain.principal.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial02.R
import com.example.parcial02.data.model.MountainModel
import com.example.parcial02.databinding.MountainItemBinding

class MountainRecyclerViewAdapter(private val clickListener : (MountainModel) -> Unit):RecyclerView.Adapter<MountainRecyclerViewHolder>(){
    private val mountains = mutableListOf<MountainModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MountainRecyclerViewHolder {
        val binding = MountainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MountainRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mountains.size
    }

    override fun onBindViewHolder(holder: MountainRecyclerViewHolder, position: Int) {
        val mountain = mountains[position]
        holder.bind(mountain, clickListener)
    }

    fun setData(mountainsList : List<MountainModel>) {
        mountains.clear()
        mountains.addAll(mountainsList)
        notifyDataSetChanged()
    }
}