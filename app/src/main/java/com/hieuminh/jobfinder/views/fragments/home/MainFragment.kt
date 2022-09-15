package com.hieuminh.jobfinder.views.fragments.home

import com.hieuminh.jobfinder.databinding.FragmentMainBinding
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override fun getViewBinding() = FragmentMainBinding.inflate(layoutInflater)

    override fun initListener() {
    }

    override fun initView() {
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
