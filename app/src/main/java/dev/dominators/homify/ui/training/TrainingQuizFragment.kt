package dev.dominators.homify.ui.training

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import dev.dominators.homify.R
import dev.dominators.homify.databinding.FragmentTrainingQuizBinding

class TrainingQuizFragment : Fragment() {

    private lateinit var fragmentQuizBinding: FragmentTrainingQuizBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentQuizBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_training_quiz,container,false)

        fragmentQuizBinding.btnCheckScore.setOnClickListener {
            Navigation.findNavController(fragmentQuizBinding.root).navigate(R.id.action_trainingQuizFragment_to_testResultFragment)
        }
        return fragmentQuizBinding.root

    }
}