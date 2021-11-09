package dev.dominators.homify.ui.JobCheck

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import dev.dominators.homify.R
import dev.dominators.homify.databinding.FragmentJobDetailPageBinding

class JobDetailPage : Fragment(R.layout.fragment_job_detail_page) {

    private lateinit var binding:FragmentJobDetailPageBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentJobDetailPageBinding.bind(view)

        binding.btnContactLead.setOnClickListener {

            val progressBar = ProgressBar(requireContext())

        }

    }
}