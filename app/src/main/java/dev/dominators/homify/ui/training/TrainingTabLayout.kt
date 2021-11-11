package dev.dominators.homify.ui.training

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayoutMediator
import dev.dominators.homify.R
import dev.dominators.homify.databinding.FragmentTrainingTabLayoutBinding

class TrainingTabLayout : Fragment() {

    lateinit var fragmentTabLayoutBinding: FragmentTrainingTabLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTabLayoutBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_training_tab_layout,container,false)
       setAdapter(fragmentTabLayoutBinding)
        return fragmentTabLayoutBinding.root
    }

    private fun setAdapter(fragmentTabLayoutBinding: FragmentTrainingTabLayoutBinding) {
        val pagerAdapter = TrainingTabPagerAdaptor(requireActivity().supportFragmentManager,lifecycle)
        fragmentTabLayoutBinding.apply {
            viewPagerBookingType.adapter = pagerAdapter
            TabLayoutMediator(tabsMyBooking,viewPagerBookingType){
                    tab,position ->
                when(position){
                    0 -> tab.text = "Virtual"
                    1 -> tab.text = "Physical"
                }
            }.attach()
        }
    }

}