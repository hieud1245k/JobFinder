package com.hieuminh.jobfinder.views.fragments.home.main

import com.hieuminh.jobfinder.databinding.FragmentTipPageBinding
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class TipPageFragment : BaseFragment<FragmentTipPageBinding>() {

    override fun getViewBinding() = FragmentTipPageBinding.inflate(layoutInflater)

    override fun initListener() {
    }

    override fun initView() {
    }

    companion object {
        @JvmStatic
        fun newInstance() = TipPageFragment()
    }
}
