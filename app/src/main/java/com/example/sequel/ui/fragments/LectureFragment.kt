package com.example.sequel.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sequel.R
import com.example.sequel.databinding.FragmentLectureBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LectureFragment : Fragment() {
    private var _binding: FragmentLectureBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLectureBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}