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
import dev.dominators.homify.datamodel.Jobs

class JobDescription : Fragment(R.layout.fragment_job_description) {

    private lateinit var binding:FragmentJobDescriptionBinding
    private lateinit var dialogBinding:DialogAcceptJobBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val intent = activity?.intent

        val jobs:Jobs = intent?.getSerializableExtra("jobs") as Jobs
        binding = FragmentJobDescriptionBinding.bind(view)

        binding.apply {
            tvJDAdd.text = jobs.address
            tvJDDate.text = jobs.date
            tvJDName.text = jobs.name
            timeJobDesc.text = jobs.time
        }
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

            binding.alternateSolution.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.action_jobDescription_to_solutionFinder2)
            }


            val bundle = Bundle()
            bundle.putSerializable("jobs",jobs)
            binding.helpJob.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.action_jobDescription_to_jobDetailPage,bundle)
            }



        }
    }

}