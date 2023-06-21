package com.example.sequel.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.sequel.data.BaseSqlData

class TextDiffCallback<T: BaseSqlData> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.text == newItem.text
    }
}