package com.example.parcial02.ui.mountain.principal.recyclerview


import androidx.recyclerview.widget.RecyclerView
import com.example.parcial02.data.model.MountainModel
import com.example.parcial02.databinding.MountainItemBinding

class MountainRecyclerViewHolder(private val binding: MountainItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(mountain: MountainModel, clickListener: (MountainModel) -> Unit){
        binding.textView3.text = mountain.Name
        binding.textView5.text = mountain.Height.toString()

        binding.cardView.setOnClickListener {
            clickListener(mountain)
        }
    }
}