package com.hieuminh.jobfinder.views.adapter

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hieuminh.jobfinder.views.fragments.home.HomeFragment
import com.hieuminh.jobfinder.views.fragments.home.MessageFragment

class HomePageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val fragments = listOf(
        HomeFragment.newInstance(),
        MessageFragment.newInstance(),
    )

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int) = fragments[position]
}
