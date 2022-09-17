package com.hieuminh.jobfinder.views.fragments.home.profile

import com.hieuminh.jobfinder.databinding.FragmentSettingBinding
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class SettingFragment : BaseFragment<FragmentSettingBinding>() {

    override fun getViewBinding() = FragmentSettingBinding.inflate(layoutInflater)

    override fun initListener() {
    }

    override fun initView() {
    }

    companion object {
        @JvmStatic
        fun newInstance() = SettingFragment()
    }
}
