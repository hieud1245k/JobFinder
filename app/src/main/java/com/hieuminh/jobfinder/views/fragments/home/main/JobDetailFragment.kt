package com.hieuminh.jobfinder.views.fragments.home.main

import com.hieuminh.jobfinder.databinding.FragmentJobDetailBinding
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class JobDetailFragment : BaseFragment<FragmentJobDetailBinding>() {

    override fun getViewBinding() = FragmentJobDetailBinding.inflate(layoutInflater)

    override fun initListener() {
    }

    override fun initView() {
    }

    companion object {
        @JvmStatic
        fun newInstance() = JobDetailFragment()
    }
}
