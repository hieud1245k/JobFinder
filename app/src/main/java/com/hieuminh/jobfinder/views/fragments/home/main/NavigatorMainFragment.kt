package com.hieuminh.jobfinder.views.fragments.home.main

import com.hieuminh.jobfinder.databinding.FragmentNavigatorMainBinding
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class NavigatorMainFragment : BaseFragment<FragmentNavigatorMainBinding>() {

    override fun getViewBinding() = FragmentNavigatorMainBinding.inflate(layoutInflater)

    override fun initListener() {
    }

    override fun initView() {
    }

    companion object {
        @JvmStatic
        fun newInstance() = NavigatorMainFragment()
    }
}
