package com.hieuminh.jobfinder.views.fragments.home.main

import com.hieuminh.jobfinder.common.extensions.ViewExtensions.navController
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.onClick
import com.hieuminh.jobfinder.databinding.FragmentTipDetailBinding
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class TipDetailFragment : BaseFragment<FragmentTipDetailBinding>() {

    override fun getViewBinding() = FragmentTipDetailBinding.inflate(layoutInflater)

    override fun initListener() {
    }

    override fun initView() {
    }

    companion object {
        @JvmStatic
        fun newInstance() = TipDetailFragment()
    }
}
