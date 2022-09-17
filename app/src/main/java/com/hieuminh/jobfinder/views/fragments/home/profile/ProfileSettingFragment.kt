package com.hieuminh.jobfinder.views.fragments.home.profile

import com.hieuminh.jobfinder.databinding.FragmentProfileSettingBinding
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class ProfileSettingFragment : BaseFragment<FragmentProfileSettingBinding>() {

    override fun getViewBinding() = FragmentProfileSettingBinding.inflate(layoutInflater)

    override fun initListener() {
    }

    override fun initView() {
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProfileSettingFragment()
    }
}
