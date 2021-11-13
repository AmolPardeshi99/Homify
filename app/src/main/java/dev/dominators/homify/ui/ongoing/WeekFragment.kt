package dev.dominators.homify.ui.ongoing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import dev.dominators.homify.R
import dev.dominators.homify.databinding.FragmentTommorowBinding
import dev.dominators.homify.databinding.FragmentWeekBinding
import dev.dominators.homify.datamodel.Jobs
import dev.dominators.homify.ui.homepage.recyclerView.AdapterOnGoing

class WeekFragment : Fragment() {


    lateinit var binding: FragmentWeekBinding
    private  var list = arrayListOf<Jobs>()
    private lateinit var adapter: AdapterOnGoing

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_week,container,false)
        builData()

        adapter = AdapterOnGoing(list)
        var linearLayoutManager = LinearLayoutManager(requireContext())
        binding.recyclerWeek.adapter = adapter
        binding.recyclerWeek.layoutManager = linearLayoutManager


        return binding.root
    }

    fun builData(){
        for(i in 0..20){
            var address = "jay mata di mandir, santosh bhuvan, valai pada road"
            val job = Jobs(address,"8237578373","10 jun","13 nov","abhimanyu","10:00 AM","job","1")
            list.add(job)
        }
    }
}