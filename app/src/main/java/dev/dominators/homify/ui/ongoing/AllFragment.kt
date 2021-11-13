package dev.dominators.homify.ui.ongoing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import dev.dominators.homify.R
import dev.dominators.homify.databinding.FragmentAllBinding
import dev.dominators.homify.datamodel.Jobs
import dev.dominators.homify.ui.homepage.recyclerView.AdapterOnGoing

class AllFragment : Fragment() {

    private lateinit var binding:FragmentAllBinding
    private  var list = arrayListOf<Jobs>()
    private lateinit var adapter: AdapterOnGoing
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_all,container,false)

        builData()

        adapter = AdapterOnGoing(list)
        var linearLayoutManager = LinearLayoutManager(requireContext())
        binding.recyclerAll.adapter = adapter
        binding.recyclerAll.layoutManager = linearLayoutManager


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