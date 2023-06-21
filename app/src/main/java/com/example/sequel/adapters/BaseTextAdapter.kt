package com.example.sequel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.sequel.data.BaseSqlData

abstract class BaseTextAdapter<T : BaseSqlData, VB : ViewBinding> :
    ListAdapter<T, BaseTextAdapter<T, VB>.BaseTextViewHolder>(TextDiffCallback<T>()) {

    inner class BaseTextViewHolder(val binding: VB) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseTextViewHolder {
        val binding = inflateViewBinding(LayoutInflater.from(parent.context), parent, false)
        return BaseTextViewHolder(binding)
    }

    abstract fun bind(holder: BaseTextViewHolder, item: T)

    override fun onBindViewHolder(holder: BaseTextViewHolder, position: Int) {
        val song = getItem(position)
        bind(holder, song)
    }

    abstract fun inflateViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean
    ): VB
}
