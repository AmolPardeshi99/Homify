package dev.dominators.homify.ui.homepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dev.dominators.homify.R
import dev.dominators.homify.databinding.FragmentOngoingBinding
import dev.dominators.homify.ui.ongoing.OngoingPagerAdapter

class OngoingFragment : Fragment(R.layout.fragment_ongoing) {

    lateinit var fragmentOngoingBinding: FragmentOngoingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentOngoingBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_ongoing,container,false)
        setAdapter(fragmentOngoingBinding)
        return fragmentOngoingBinding.root
    }

    private fun setAdapter(fragmentOngoingBinding: FragmentOngoingBinding?) {
        val pagerAdapter = OngoingPagerAdapter(requireActivity().supportFragmentManager,lifecycle)
        fragmentOngoingBinding?.apply {
            ongoingViewPager.adapter = pagerAdapter
            TabLayoutMediator(ongoingTabLayout,ongoingViewPager){tab,position ->
                when(position){
                    0 -> tab.text = "All"
                    1 -> tab.text = "Today"
                    2 -> tab.text = "Tomorrow"
                    3 -> tab.text = "Week"
                }
            }.attach()

        }



    }


}