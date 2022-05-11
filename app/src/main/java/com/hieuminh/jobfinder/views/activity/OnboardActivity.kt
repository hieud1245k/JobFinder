package com.hieuminh.jobfinder.views.activity

import android.view.View
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.gone
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.visible
import com.hieuminh.jobfinder.databinding.ActivityOnboardBinding
import com.hieuminh.jobfinder.navigators.OnBoardingNavigator
import com.hieuminh.jobfinder.navigators.OnBoardingNavigatorImpl
import com.hieuminh.jobfinder.views.activity.base.BaseActivity

class OnboardActivity : BaseActivity<ActivityOnboardBinding>() {
    override fun getViewBinding() = ActivityOnboardBinding.inflate(layoutInflater)

    override fun startLoading() {
        binding.layoutLoading.llLoadingView.visible()
    }

    override fun endLoading() {
        binding.layoutLoading.llLoadingView.gone()
    }

    override fun initListener() = Unit

    fun getNavigator(view: View?): OnBoardingNavigator {
        return OnBoardingNavigatorImpl(view)
    }

    override fun initView() = Unit
}
