package com.example.parcial02.ui.mountain.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.parcial02.MountainReviewerApplication
import com.example.parcial02.data.model.MountainModel
import com.example.parcial02.repository.MountainRepository

class MountainViewModel (private val repository: MountainRepository) : ViewModel() {
    var name = MutableLiveData("")
    var height = MutableLiveData("")
    var status = MutableLiveData("")

    fun getMountain() = repository.getMountain()

    fun addMountain(mountain : MountainModel) {
        repository.addMountain(mountain)
    }

    fun createMountain(){
        if (!validateData()) {
            status.value = WRONG_DATA
            return
        }
        val mountain = MountainModel(name.value!!, height.value!!.toFloat())
        addMountain(mountain)
        clearData()

        status.value = MOUNTAIN_CREATED
    }

    private fun validateData () : Boolean {
        if(name.value!!.isEmpty() || height.value!!.isEmpty()) {
            return false
        }
        if(height.value!!.toFloat() < 0) {
            return false
        }
        return true
    }

    fun clearData() {
        name.value = ""
        height.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

//    fun setSelectedMountain(mountain: MountainModel) {
//        name.value = mountain
//    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MountainReviewerApplication
                MountainViewModel(app.mountainRepository)
            }
        }

        const val MOUNTAIN_CREATED = "Mountain created"
        const val WRONG_DATA = "Wrong data"
        const val INACTIVE = ""
    }
}