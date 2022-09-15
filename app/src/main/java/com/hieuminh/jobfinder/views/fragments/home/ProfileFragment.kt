package com.hieuminh.jobfinder.views.fragments.home

import com.hieuminh.jobfinder.databinding.FragmentProfileBinding
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override fun getViewBinding() = FragmentProfileBinding.inflate(layoutInflater)

    override fun initListener() {
    }

    override fun initView() {
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}
