package com.example.paing3kotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.paing3kotlin.api.ApiInterface
import java.lang.IllegalArgumentException

class MainViewModelFactory(private val service: ApiInterface): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(service) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class!")
    }
}