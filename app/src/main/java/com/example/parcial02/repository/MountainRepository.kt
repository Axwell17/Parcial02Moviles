package com.example.parcial02.repository

import com.example.parcial02.data.model.MountainModel

class MountainRepository (private val mountain: MutableList<MountainModel>) {
    
    fun addMountain(mountain: MountainModel) = this.mountain.add(mountain)

    fun getMountain() = mountain
}