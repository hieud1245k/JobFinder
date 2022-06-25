package com.hieuminh.jobfinder.views.fragments

import com.hieuminh.jobfinder.R
import com.hieuminh.jobfinder.navigators.OnBoardingNavigator
import com.hieuminh.jobfinder.navigators.OnBoardingNavigatorImpl

class ActiveAccountSuccessfulFragment: SuccessFragment() {
    private var mNavigator: OnBoardingNavigator? = null

    override fun openToPage() {
        mNavigator?.startToInitProfile()
    }

    override fun initView() {
        super.initView()
        mNavigator = OnBoardingNavigatorImpl(binding?.root)
        binding?.tvSuccessMessage?.text = resources.getString(R.string.active_account_successful)
        binding?.tvContinue?.text = resources.getString(R.string.continue_to_register)
    }
}