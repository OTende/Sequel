package com.example.sequel.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sequel.adapters.PracticeAdapter
import com.example.sequel.databinding.FragmentPracticeBinding
import com.example.sequel.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PracticeFragment : Fragment() {
    private val viewModel: MainViewModel by activityViewModels()

    @Inject
    lateinit var practiceAdapter: PracticeAdapter

    private var _binding: FragmentPracticeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPracticeBinding.inflate(inflater, container, false)
        viewModel.practiceList.observe(viewLifecycleOwner) {
            practiceAdapter.submitList(it)
        }
        binding.practiceRv.adapter = practiceAdapter
        binding.practiceRv.layoutManager = LinearLayoutManager(context)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}