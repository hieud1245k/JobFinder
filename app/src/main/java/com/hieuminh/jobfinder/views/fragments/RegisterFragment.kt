package com.hieuminh.jobfinder.views.fragments

import android.view.View
import com.hieuminh.jobfinder.databinding.FragmentRegisterBinding
import com.hieuminh.jobfinder.navigators.OnBoardingNavigator
import com.hieuminh.jobfinder.navigators.OnBoardingNavigatorImpl
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {
    private var mNavigator: OnBoardingNavigator? = null

    override fun getViewBinding() = FragmentRegisterBinding.inflate(layoutInflater)

    private val signInClickListener = View.OnClickListener {
        mNavigator?.backToLogin()
    }

    override fun initListener() {
        binding?.tvSignIn?.setOnClickListener(signInClickListener)
    }

    override fun initView() {
        mNavigator = OnBoardingNavigatorImpl(binding?.root)
    }
}
