package com.example.parcial02.ui.mountain.principal.recyclerview

import android.widget.ExpandableListView.OnChildClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial02.data.model.MountainModel

class MountainRecyclerViewHolder(private val binding: MountainItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(mountain: MountainModel, clickListener: (MountainModel) -> Unit){
        binding.tvName.text = mountain.Name
        binding.tvHeight.text = mountain.Height.toString()

        binding.cardView.setOnClickListener {
            clickListener(mountain)
        }
    }
}