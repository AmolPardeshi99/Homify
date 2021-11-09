package dev.dominators.homify.ui.JobCheck

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import dev.dominators.homify.R
import dev.dominators.homify.databinding.DialogAcceptJobBinding
import dev.dominators.homify.databinding.FragmentJobDescriptionBinding

class JobDescription : Fragment(R.layout.fragment_job_description) {

    private lateinit var binding:FragmentJobDescriptionBinding
    private lateinit var dialogBinding:DialogAcceptJobBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentJobDescriptionBinding.bind(view)

        binding.acceptJob.setOnClickListener {
            val dialog = Dialog(requireContext())
            val view1 = layoutInflater.inflate(R.layout.dialog_accept_job,null)
            dialog.setContentView(view1)
            dialog.setCancelable(false)
            dialog.show()

            dialogBinding = DialogAcceptJobBinding.bind(view1)
            dialogBinding.okDialog.setOnClickListener {
                dialog.dismiss()
                binding.apply {
                    acceptJob.visibility = View.GONE
                    alternateSolution.visibility = View.VISIBLE
                    helpJob.visibility = View.VISIBLE
                }
            }

            binding.helpJob.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.action_jobDescription_to_jobDetailPage)
            }



        }
    }

}