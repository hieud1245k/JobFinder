package com.hieuminh.jobfinder.views.activity

import com.google.android.material.tabs.TabLayoutMediator
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.gone
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.visible
import com.hieuminh.jobfinder.databinding.ActivityMainBinding
import com.hieuminh.jobfinder.views.activity.base.BaseActivity
import com.hieuminh.jobfinder.views.adapter.HomePageAdapter

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun startLoading() {
        binding.layoutLoading.llLoadingView.visible()
    }

    override fun endLoading() {
        binding.layoutLoading.llLoadingView.gone()
    }

    override fun initListener() {
    }

    override fun initView() {
        binding.viewPager.adapter = HomePageAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Home"
                else -> "Message"
            }
        }
    }
}
