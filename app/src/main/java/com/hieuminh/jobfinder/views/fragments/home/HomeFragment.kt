package com.hieuminh.jobfinder.views.fragments.home

import com.hieuminh.jobfinder.databinding.FragmentHomeBinding
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)

    override fun initListener() {
    }

    override fun initView() {
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
