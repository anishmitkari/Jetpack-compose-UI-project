package com.anish.jetpackcompose.Codetutor

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainscreenViewmodel : ViewModel() {
    var counter = MutableLiveData<Int>(0)

    var Increment ={
        counter.value =counter.value?.plus(1)
    }
    var Decrement ={
        counter.value=counter.value?.minus(1)
    }
}