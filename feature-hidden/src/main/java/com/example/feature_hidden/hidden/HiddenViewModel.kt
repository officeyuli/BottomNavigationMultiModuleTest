package com.example.feature_hidden.hidden

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HiddenViewModel : ViewModel() {
    fun resetText(newText: String) {
        _text.value = newText
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is hidden Fragment"
    }
    val text: LiveData<String> = _text
}