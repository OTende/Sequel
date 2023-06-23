package com.example.sequel.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.sequel.R
import com.example.sequel.databinding.FragmentPracticeCompletionBinding
import com.example.sequel.ui.viewmodels.MainViewModel

class FragmentPracticeCompletion : Fragment() {
    private var _binding: FragmentPracticeCompletionBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPracticeCompletionBinding.inflate(inflater, container, false)
        val id = requireArguments().getInt(PRACTICE_COMPLETION_KEY)
        val practice = viewModel.getPractice(id)
        binding.questionTv.text = practice.text
        return binding.root
    }

    companion object {
        const val PRACTICE_COMPLETION_KEY = "FragmentPracticeCompletion"
    }
}