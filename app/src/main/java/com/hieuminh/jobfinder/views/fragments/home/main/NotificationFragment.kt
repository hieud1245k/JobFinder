package com.hieuminh.jobfinder.views.fragments.home.main

import com.hieuminh.jobfinder.databinding.FragmentNotificationBinding
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {

    override fun getViewBinding() = FragmentNotificationBinding.inflate(layoutInflater)

    override fun initListener() {
    }

    override fun initView() {
    }

    companion object {
        @JvmStatic
        fun newInstance() = NotificationFragment()
    }
}
