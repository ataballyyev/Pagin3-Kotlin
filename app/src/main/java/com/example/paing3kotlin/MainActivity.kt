package com.example.paing3kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paing3kotlin.adapter.MainAdapter
import com.example.paing3kotlin.api.ApiInterface
import com.example.paing3kotlin.viewmodel.MainViewModel
import com.example.paing3kotlin.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupList()
        setupView()


    }

    private fun setupView() {
        lifecycleScope.launch {
            viewModel.listData.collect { pagingData ->
                adapter.submitData(pagingData)
            }
        }
    }

    private fun setupList() {
        adapter = MainAdapter()
        rv_main.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapter
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, MainViewModelFactory(ApiInterface.getApiService())).get(MainViewModel::class.java)
    }
}