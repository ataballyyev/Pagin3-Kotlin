package com.example.paing3kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paing3kotlin.R
import com.example.paing3kotlin.data.Data

class MainAdapter : PagingDataAdapter<Data, MainAdapter.MainViewHolder>(DataDifferntiator) {
    class MainViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.textViewName)
        val email: TextView = view.findViewById(R.id.textViewEmail)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.name.text = "${getItem(position)?.firstName} ${getItem(position)?.lastName}"
        holder.email.text = getItem(position)?.email
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MainViewHolder(view)
    }

    object DataDifferntiator : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }

    }
}