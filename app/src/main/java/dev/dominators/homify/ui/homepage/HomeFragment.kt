package dev.dominators.homify.ui.homepage

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import dev.dominators.homify.R
import dev.dominators.homify.databinding.ActivityMainBinding
import dev.dominators.homify.databinding.FragmentHomeBinding
import dev.dominators.homify.ui.homepage.diffutil.NewJobAdapter
import dev.dominators.homify.ui.homepage.diffutil.NewJobData

class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var fragmentHomeBinding: FragmentHomeBinding
    var newJobList = arrayListOf<NewJobData>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)
        buildData()
    }

    override fun onResume() {
        super.onResume()
        setAdaptor()
    }

    private fun setAdaptor() {
        val linearLayoutManager = LinearLayoutManager(context)
        val newJobAdapter = NewJobAdapter()
        fragmentHomeBinding.newJobRecycler.apply {
            adapter = newJobAdapter
            layoutManager = linearLayoutManager
            newJobAdapter.updateData(newJobList)
        }

    }

    private fun buildData() {
        for (i in 1..3){
            val newJobData = NewJobData("10:00 PM","Ranjan${i}",
                "Plot No.61, JP Colony, Jalgaon, Maharashtra, India","9:00 PM",
                "12 Dec 2021",1234567800,"I want best service",
                1200.0000f,0.0000f,0.0000f)
            newJobList.add(newJobData)
        }
    }

}