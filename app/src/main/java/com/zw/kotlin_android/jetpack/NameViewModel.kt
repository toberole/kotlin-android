package com.zw.kotlin_android.jetpack

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameViewModel : ViewModel() {
    private var currentName: MutableLiveData<String> = MutableLiveData()
    private var names: MutableLiveData<List<String>> = MutableLiveData()

    fun getCurrentName(): MutableLiveData<String> {
        return currentName
    }

    fun getNames(): MutableLiveData<List<String>> {
        return names
    }

}