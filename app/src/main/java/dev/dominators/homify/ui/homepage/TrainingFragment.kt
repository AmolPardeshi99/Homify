package dev.dominators.homify.ui.homepage

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import dev.dominators.homify.R
import dev.dominators.homify.databinding.FragmentTrainingBinding
import dev.dominators.homify.ui.training.TrainingProcess

class TrainingFragment : Fragment(R.layout.fragment_training) {
    private lateinit var binding:FragmentTrainingBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding = FragmentTrainingBinding.bind(view)

        binding.apply {
            onPresentJob.setOnClickListener {
                val intent = Intent(requireContext(),TrainingProcess::class.java)
                startActivity(intent)
            }

            learnNewJob.setOnClickListener {
                val intent = Intent(requireContext(),TrainingProcess::class.java)
                startActivity(intent)
            }
        }

    }

}