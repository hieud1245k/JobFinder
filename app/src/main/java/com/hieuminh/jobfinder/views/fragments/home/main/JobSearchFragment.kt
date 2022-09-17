package com.hieuminh.jobfinder.views.fragments.home.main

import com.hieuminh.jobfinder.databinding.FragmentJobSearchBinding
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class JobSearchFragment : BaseFragment<FragmentJobSearchBinding>() {

    override fun getViewBinding() = FragmentJobSearchBinding.inflate(layoutInflater)

    override fun initListener() {
    }

    override fun initView() {
    }

    companion object {
        @JvmStatic
        fun newInstance() = JobSearchFragment()
    }
}
