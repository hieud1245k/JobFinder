package com.hieuminh.jobfinder.views.fragments.home

import com.hieuminh.jobfinder.databinding.FragmentApplicationBinding
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class ApplicationFragment : BaseFragment<FragmentApplicationBinding>() {

    override fun getViewBinding() = FragmentApplicationBinding.inflate(layoutInflater)

    override fun initListener() {
    }

    override fun initView() {
    }

    companion object {
        @JvmStatic
        fun newInstance() = ApplicationFragment()
    }
}
