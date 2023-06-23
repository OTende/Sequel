package com.example.sequel.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.sequel.R
import com.example.sequel.data.Practice
import com.example.sequel.databinding.FragmentPracticeBinding
import com.example.sequel.databinding.PracticeListItemBinding
import com.example.sequel.ui.fragments.FragmentPracticeCompletion
import javax.inject.Inject

class PracticeAdapter @Inject constructor() : BaseTextAdapter<Practice, PracticeListItemBinding>() {
    override fun bind(holder: BaseTextViewHolder, item: Practice) {
        holder.binding.apply {
//            .text = item.text
            questionTv.text = item.topic
            questionTv.setOnClickListener {
                holder.binding.root.findNavController().navigate(
                    R.id.action_practiceFragment_to_fragmentPracticeCompletion,
                    Bundle().apply {
                        putInt(
                            FragmentPracticeCompletion.PRACTICE_COMPLETION_KEY,
                            item.id
                        )
                    }
                )
            }
        }
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean
    ): PracticeListItemBinding {
        return PracticeListItemBinding.inflate(inflater, parent, false)
    }
}