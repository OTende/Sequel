package com.example.sequel.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sequel.R
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

        // Fill radio group
        for (i in 0 until practice.answers.size) {
            val button = RadioButton(requireContext())
            button.text = practice.answers[i]
            button.id = i
            button.textSize = 20F

            button.layoutParams = ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            button.setOnCheckedChangeListener { _, _ ->
                binding.nextButton.isEnabled = true
            }

            buttonList.add(button)
        }

        buttonList.shuffled().forEach {
            binding.answersRg.addView(it)
        }

        binding.nextButton.setOnClickListener {
            val checkedId = binding.answersRg.checkedRadioButtonId
            // If the answer is correct
            if (checkedId == 0) {
                binding.answersRg.findViewById<RadioButton>(checkedId).apply {
                    this.setBackgroundColor(resources.getColor(R.color.color_correct, context?.theme))
                    this.setTextColor(resources.getColor(R.color.black, context?.theme))
                }

                viewModel.completePractice(id)
                viewModel.updatePracticeList()
                binding.nextButton.text = getText(R.string.return_to_menu)
                Toast.makeText(context, getString(R.string.correct), Toast.LENGTH_LONG).show()

                binding.nextButton.setOnClickListener {
                    findNavController().popBackStack()
                }
            } else {
                binding.answersRg.findViewById<RadioButton>(checkedId)
                    .setBackgroundColor(resources.getColor(R.color.color_wrong, context?.theme))
                Toast.makeText(context, getString(R.string.error), Toast.LENGTH_LONG).show()
            }
        }

        binding.questionTv.text = practice.text
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