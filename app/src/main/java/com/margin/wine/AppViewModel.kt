package com.margin.wine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppViewModel : ViewModel() {
    private val _navLiveData = MutableLiveData<Int>()
    val navLiveData: LiveData<Int> get() = _navLiveData
}