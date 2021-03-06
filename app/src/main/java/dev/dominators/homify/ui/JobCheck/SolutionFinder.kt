package dev.dominators.homify.ui.JobCheck

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.dominators.homify.R
import dev.dominators.homify.databinding.FragmentSolutionFinderBinding

class SolutionFinder : Fragment(R.layout.fragment_solution_finder) {

    private lateinit var binding:FragmentSolutionFinderBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSolutionFinderBinding.bind(view)

        binding.apply {

            var worker = false
            var customer = false
            workerSupportBtn.setOnClickListener {
                if(workerMakeCall.visibility == View.GONE){
                    workerMakeCall.visibility = View.VISIBLE
                }else{
                    workerMakeCall.visibility = View.GONE
                }

                if(worker){
                    workerSupportBtn.setBackgroundColor(Color.WHITE)
                    worker = false
                }else{
                    workerSupportBtn.setBackgroundColor(Color.parseColor("#E0E6FF"))
                    worker = true
                }
            }

            customerSupportBtn.setOnClickListener {
                if(customerMakeCall.visibility == View.VISIBLE){
                    customerMakeCall.visibility = View.GONE
                }else{
                    customerMakeCall.visibility = View.VISIBLE
                }

                if(customer){
                    customerSupportBtn.setBackgroundColor(Color.WHITE)
                    customer = false
                }else{
                    customerSupportBtn.setBackgroundColor(Color.parseColor("#E0E6FF"))
                    customer = true
                }
            }

        }
    }

}