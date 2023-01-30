package com.example.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel() {
    private var _count = MutableLiveData<Int>()

    val count : LiveData<Int>
        get() = _count
    init {
        _count.value = 0
    }
    fun increase(){
        _count.value = _count.value?.plus(1)
    }
}