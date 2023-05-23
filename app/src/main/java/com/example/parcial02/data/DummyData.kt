package com.example.parcial02.data

import com.example.parcial02.data.model.MountainModel

val name = "Cerro Chirripó"
val height = 3820.0f

val name2 = "Cerro Kamuk"
val height2 = 3240.0f

val name3 = "Cerro Buenavista"
val height3 = 3000.0f

val name4 = "Cerro de la Muerte"
val height4 = 3491.0f

var mountains = mutableListOf(
    MountainModel(name, height),
    MountainModel(name2, height2),
    MountainModel(name3, height3),
    MountainModel(name4, height4)
)