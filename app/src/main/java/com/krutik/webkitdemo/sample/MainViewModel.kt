package com.krutik.webkitdemo.sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SharedViewModel() : ViewModel() {

    private val _route = MutableLiveData<String>()
    val route: LiveData<String> get() = _route

    private val _index = MutableLiveData<Int>()
    val index: LiveData<Int> get() = _index

    fun setRoute(route: String) {
        println("testing nav native to js " + route)
        _route.value = route
    }

    fun setIndex(index: Int) {
        println("testing nav native to js " + route)
        _index.value = index
    }
}