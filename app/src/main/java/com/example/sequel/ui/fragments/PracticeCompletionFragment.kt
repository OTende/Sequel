package com.example.sequel.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.sequel.databinding.FragmentPracticeCompletionBinding
import com.example.sequel.ui.viewmodels.MainViewModel

private const val SELECTED_ID_KEY = "Selected Id Key"

class PracticeCompletionFragment : Fragment() {
    private var _binding: FragmentPracticeCompletionBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    private var practiceId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPracticeCompletionBinding.inflate(inflater, container, false)
        setupUi()

        if (savedInstanceState != null) {
            practiceId = savedInstanceState.getInt(SELECTED_ID_KEY)
            binding.answersRg.check(practiceId)
        }

        return binding.root
    }

    private fun setupUi() {
        val id = requireArguments().getInt(PRACTICE_COMPLETION_KEY)
        val practice = viewModel.getPractice(id)
        val buttonList = mutableListOf<RadioButton>()

        for (i in 0 until practice.answers.size) {
            val button = RadioButton(requireContext())
            button.text = practice.answers[i] // practice.answers[i]
            button.id = i
            button.setOnCheckedChangeListener { _, _ ->
                binding.nextButton.isEnabled = true
            }
            buttonList.add(button)
        }

        buttonList.shuffled().forEach {
            binding.answersRg.addView(it)
        }

        binding.questionTv.text = practice.text

        binding.nextButton.setOnClickListener {
            if (binding.answersRg.checkedRadioButtonId == 0) {
                viewModel.completePractice(id)
                Toast.makeText(requireContext(), "asd", Toast.LENGTH_SHORT).show()
                viewModel.updateLists()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SELECTED_ID_KEY, practiceId)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val PRACTICE_COMPLETION_KEY = "FragmentPracticeCompletion"
    }
}