package com.example.sequel.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.activityViewModels
import com.example.sequel.databinding.FragmentPracticeCompletionBinding
import com.example.sequel.ui.viewmodels.MainViewModel

class FragmentPracticeCompletion : Fragment() {
    private var _binding: FragmentPracticeCompletionBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    private var practiceId = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPracticeCompletionBinding.inflate(inflater, container, false)
        setupUi(practiceId)
        if (savedInstanceState != null) {
            practiceId = savedInstanceState.getInt("asd")
            binding.answersRg.check(practiceId)
        }
        return binding.root
    }

    private fun setupUi(selectedIndex: Int) {
        val id = requireArguments().getInt(PRACTICE_COMPLETION_KEY)
        val practice = viewModel.getPractice(id)
        for (i in 0 until practice.answers.size) {
//            practiceViewModel.practiceId = i
            val button = RadioButton(requireContext())
            button.text = practice.answers[i]
            button.id = i
            button.setOnCheckedChangeListener { _, _ ->
                binding.nextButton.isEnabled = true
//                practiceViewModel.practiceId = practice.answers[i]
            }
            binding.answersRg.addView(button)
        }
//        binding.answersRg.check(selectedIndex)
//        binding.answersRg[selectedIndex] = true
        binding.answersRg.setOnCheckedChangeListener { _, checkedId ->
            practiceId = checkedId
            Toast.makeText(requireContext(), "$checkedId", Toast.LENGTH_LONG).show()
        }

//        binding.nextButton.setOnClickListener {
//            if (practice.answers[0] == practiceViewModel.practiceId)
//                Toast.makeText(requireContext(), "asd", Toast.LENGTH_LONG).show()
//            if (binding.answersRg.check practice.answers[0])
//        }
        binding.questionTv.text = practice.text
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("asd", practiceId)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val PRACTICE_COMPLETION_KEY = "FragmentPracticeCompletion"
    }
}