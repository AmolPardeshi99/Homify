package dev.dominators.homify.ui.JobCheck

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import dev.dominators.homify.R
import dev.dominators.homify.databinding.FragmentJobDetailPageBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

class JobDetailPage : Fragment(R.layout.fragment_job_detail_page) {

    private lateinit var binding: FragmentJobDetailPageBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentJobDetailPageBinding.bind(view)

        binding.btnContactLead.setOnClickListener {

            val progressBar = ProgressDialog(requireContext())
            progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            progressBar.setMessage("Contacting lead")
            progressBar.show()

            CoroutineScope(Dispatchers.Main).async {
                delay(5000)

                Navigation.findNavController(view).navigate(R.id.action_jobDetailPage_to_solutionFinder)
                progressBar.dismiss()


            }

        }

    }
}