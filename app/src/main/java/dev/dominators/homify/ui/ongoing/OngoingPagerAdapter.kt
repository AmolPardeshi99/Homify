package dev.dominators.homify.ui.ongoing

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter

class OngoingPagerAdapter: FragmentPagerAdapter(val fra) {

    private val fragmentList = arrayListOf<Fragment>()
    private val titleList = arrayListOf<String>()


    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
    return fragmentList.get(position)
    }

    fun addFragments(fragment: Fragment, title: String){
        fragmentList.add(fragment)
        titleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {

        return titleList[position]
    }
}