package com.example.paing3kotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.paing3kotlin.api.ApiInterface
import com.example.paing3kotlin.repository.PostDataSource

class MainViewModel(private val service: ApiInterface): ViewModel() {
    val listData = Pager(PagingConfig(pageSize = 6)) {
        PostDataSource(service)
    }.flow.cachedIn(viewModelScope)
}