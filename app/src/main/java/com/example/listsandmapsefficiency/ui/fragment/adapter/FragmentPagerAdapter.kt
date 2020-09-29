package com.example.listsandmapsefficiency.ui.fragment.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.listsandmapsefficiency.ui.fragment.ListsFragment
import com.example.listsandmapsefficiency.ui.fragment.MapsFragment
import com.example.listsandmapsefficiency.util.Constants

class FragmentPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            ListsFragment.newInstance()
        } else {
            MapsFragment.newInstance()
        }
    }

    override fun getItemCount(): Int {
        return Constants.PAGE_COUNT
    }
}