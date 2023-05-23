package com.example.parcial02.repository

import com.example.parcial02.data.model.MountainModel

class MountainRepository (private val mountains: MutableList<MountainModel>) {

    fun addMountain(mountain: MountainModel) = mountains.add(mountain)

    fun getMountain() = mountains
}