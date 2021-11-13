package dev.dominators.homify.ui.homepage

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import dev.dominators.homify.R
import dev.dominators.homify.databinding.FragmentHomeBinding
import dev.dominators.homify.ui.homepage.diffutil.NewJobAdapter
import dev.dominators.homify.ui.homepage.diffutil.NewJobData

class HomeFragment : Fragment() {



    lateinit var fragmentHomeBinding: FragmentHomeBinding
    var newJobList = arrayListOf<NewJobData>()
    lateinit var newJobAdapter: NewJobAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentHomeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        val view = fragmentHomeBinding.root
        val recyclerView = fragmentHomeBinding.newJobRecycler
        recyclerView.layoutManager = LinearLayoutManager(context)
        buildData()
        newJobAdapter = NewJobAdapter(newJobList)
        recyclerView.adapter = newJobAdapter
        return view
    }



    private fun buildData() {
        for (i in 1..3){
            val newJobData = NewJobData("10:00 PM","Ranjan${1}",
                "Plot No.61, JP Colony, Jalgaon, Maharashtra, India","9:00 PM",
                "12 Dec 2021",1234567800,"I want best service",
                1200.0000f,0.0000f,0.0000f)
            newJobList.add(newJobData)

        }
    }

}