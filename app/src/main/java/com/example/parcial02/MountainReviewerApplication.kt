package com.example.parcial02

import android.app.Application
import com.example.parcial02.data.mountains
import com.example.parcial02.repository.MountainRepository

class MountainReviewerApplication : Application() {
    val mountainRepository : MountainRepository by lazy {
        MountainRepository(mountains)
    }
}