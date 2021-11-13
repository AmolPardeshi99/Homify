package dev.dominators.homify.ui.JobCheck

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import dev.dominators.homify.R
import dev.dominators.homify.databinding.FragmentJobDetailPageBinding
import dev.dominators.homify.datamodel.Jobs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

class JobDetailPage : Fragment(R.layout.fragment_job_detail_page) {

    private lateinit var binding: FragmentJobDetailPageBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentJobDetailPageBinding.bind(view)

        binding.jobDataModel = arguments?.getSerializable("jobs") as Jobs

        binding.btnContactLead.setOnClickListener {

            val progressBar = ProgressDialog(requireContext())
            progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            progressBar.setMessage("Contacting lead")
            progressBar.show()


            CoroutineScope(Dispatchers.Main).async {
                delay(5000)

                val intent = Intent(Intent.ACTION_CALL)
                intent.data = Uri.parse("tel:${+917248975999}")
                startActivity(intent)
                progressBar.dismiss()
            }

        }

    }
}