package com.example.sequel.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sequel.adapters.LectureAdapter
import com.example.sequel.databinding.FragmentLectureBinding
import com.example.sequel.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LectureFragment : Fragment() {
    private val viewModel: MainViewModel by viewModels()
    @Inject
    lateinit var lectureAdapter: LectureAdapter

    private var _binding: FragmentLectureBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLectureBinding.inflate(layoutInflater, container, false)
        binding.lectureRv.adapter = lectureAdapter
        binding.lectureRv.layoutManager = LinearLayoutManager(context)
        viewModel.lectureList.observe(viewLifecycleOwner) {
            lectureAdapter.submitList(it)
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}