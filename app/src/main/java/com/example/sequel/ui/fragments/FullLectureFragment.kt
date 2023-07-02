package com.example.sequel.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sequel.R
import com.example.sequel.databinding.FragmentFullLectureBinding

class FullLectureFragment : Fragment() {
    private var _binding: FragmentFullLectureBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFullLectureBinding.inflate(inflater, container, false)
        binding.lectureTv.text = requireArguments().getString(FULL_LECTURE_KEY)
        binding.headerTv.text = requireArguments().getString(HEADER_KEY)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val FULL_LECTURE_KEY = "FullLectureFragmentText"
        const val HEADER_KEY = "FullLectureFragmentHeader"
    }
}