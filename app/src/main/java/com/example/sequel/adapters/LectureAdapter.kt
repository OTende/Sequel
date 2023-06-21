package com.example.sequel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.sequel.data.Lecture
import com.example.sequel.databinding.FragmentLectureBinding
import com.example.sequel.databinding.LectureListItemBinding
import javax.inject.Inject

class LectureAdapter @Inject constructor() : BaseTextAdapter<Lecture, LectureListItemBinding>() {
    override fun bind(holder: BaseTextViewHolder, item: Lecture) {
        holder.binding.lectureTv.text = item.header
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean
    ): LectureListItemBinding {
        return LectureListItemBinding.inflate(inflater, parent, false)
    }

}