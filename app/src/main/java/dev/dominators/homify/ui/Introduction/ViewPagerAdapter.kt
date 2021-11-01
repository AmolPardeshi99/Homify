package dev.dominators.homify.ui.Introduction

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return IntroFragOne()
            1 -> return IntroFragTwo()
            2 -> return IntroFragThree()
        }
        return IntroFragOne()
    }

    override fun getItemCount(): Int {
        return 3
    }
}