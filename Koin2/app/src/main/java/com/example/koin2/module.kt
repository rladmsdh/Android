package com.example.koin2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SampleRepository() {
    val sampleData = "Sample Data"
}

class SampleController(private val repository: SampleRepository){
    fun print(){
        Log.d("Print sample data!!!", repository.sampleData)
    }
}

class SampleViewModel : ViewModel(){
    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading
}