package com.example.sequel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.sequel.R
import com.example.sequel.data.Lecture
import com.example.sequel.databinding.LectureListItemBinding
import com.example.sequel.ui.fragments.FullLectureFragment
import javax.inject.Inject

class LectureAdapter @Inject constructor() : BaseTextAdapter<Lecture, LectureListItemBinding>() {
    override fun bind(holder: BaseTextViewHolder, item: Lecture) {
        holder.binding.apply {
            headerTv.text = item.header
            mainText.text = item.text
            val bundle = bundleOf(
                FullLectureFragment.FULL_LECTURE_KEY to item.text,
                FullLectureFragment.HEADER_KEY to item.header
            )
            root.setOnClickListener {
                it.findNavController().navigate(
                    R.id.action_lectureFragment_to_fullLectureFragment,
                    bundle
                )
            }
        }
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean
    ): LectureListItemBinding {
        return LectureListItemBinding.inflate(inflater, parent, false)
    }

}