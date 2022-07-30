package com.hieuminh.jobfinder.views.activity

import com.hieuminh.jobfinder.common.extensions.ViewExtensions.gone
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.visible
import com.hieuminh.jobfinder.databinding.ActivityInitProfileBinding
import com.hieuminh.jobfinder.views.activity.base.BaseActivity

class InitProfileActivity : BaseActivity<ActivityInitProfileBinding>() {
    override fun getViewBinding() = ActivityInitProfileBinding.inflate(layoutInflater)

    override fun startLoading() {
        binding.layoutLoading.llLoadingView.visible()
    }

    override fun endLoading() {
        binding.layoutLoading.llLoadingView.gone()
    }

    override fun initListener() {
    }

    override fun initView() {
    }
}