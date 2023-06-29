package com.example.sequel.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.sequel.R
import com.example.sequel.data.Practice
import com.example.sequel.databinding.PracticeListItemBinding
import com.example.sequel.ui.fragments.PracticeCompletionFragment
import javax.inject.Inject

class PracticeAdapter @Inject constructor() : BaseTextAdapter<Practice, PracticeListItemBinding>() {
    override fun bind(holder: BaseTextViewHolder, item: Practice) {
        holder.binding.apply {
            questionTv.text = item.topic
            practiceChecked.isChecked = item.isComplete
            questionTv.setOnClickListener {
                holder.binding.root.findNavController().navigate(
                    R.id.action_practiceFragment_to_fragmentPracticeCompletion,
                    Bundle().apply {
                        putInt(
                            PracticeCompletionFragment.PRACTICE_COMPLETION_KEY,
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