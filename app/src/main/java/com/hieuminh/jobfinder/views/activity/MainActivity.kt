package com.hieuminh.jobfinder.views.activity

import com.hieuminh.jobfinder.common.extensions.ViewExtensions.gone
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.visible
import com.hieuminh.jobfinder.databinding.ActivityMainBinding
import com.hieuminh.jobfinder.views.activity.base.BaseActivity
import com.hieuminh.jobfinder.views.fragments.home.HomeFragment

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
        supportFragmentManager.beginTransaction().add(binding.flContent.id, HomeFragment.newInstance()).commit()
    }
}
