package dev.dominators.homify.ui.training

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import dev.dominators.homify.R
import dev.dominators.homify.databinding.FragmentVirtualTrainingBinding

class VirtualTrainingFragment : Fragment(R.layout.fragment_virtual_training) {

    private lateinit var binding:FragmentVirtualTrainingBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentVirtualTrainingBinding.bind(view)

        binding.improveWorkingSkill.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_trainingTabLayout_to_trainingQuizFragment)
        }
    }

}