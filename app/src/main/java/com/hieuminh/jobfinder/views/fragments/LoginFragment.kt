package com.hieuminh.jobfinder.views.fragments

import android.view.View
import com.hieuminh.jobfinder.databinding.FragmentLoginBinding
import com.hieuminh.jobfinder.navigators.OnBoardingNavigator
import com.hieuminh.jobfinder.views.activity.OnboardActivity
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    private var mNavigator: OnBoardingNavigator? = null

    override fun getViewBinding() = FragmentLoginBinding.inflate(layoutInflater)

    private val signUpClickListener = View.OnClickListener {
        mNavigator?.startToRegister()
    }

    private val forgotPasswordClickListener = View.OnClickListener {
        mNavigator?.startToForgotPassword()
    }

    override fun initListener() {
        binding?.tvSignUp?.setOnClickListener(signUpClickListener)
        binding?.tvForgotPassword?.setOnClickListener(forgotPasswordClickListener)
    }

    override fun initView() {
        mNavigator = (activity as? OnboardActivity)?.getNavigator(binding?.root)
    }
}
