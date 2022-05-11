package com.hieuminh.jobfinder.views.fragments

import android.view.View
import com.hieuminh.jobfinder.databinding.FragmentLoginBinding
import com.hieuminh.jobfinder.models.response.LoginRes
import com.hieuminh.jobfinder.navigators.OnBoardingNavigator
import com.hieuminh.jobfinder.presenters.LoginContract
import com.hieuminh.jobfinder.presenters.impl.LoginContractImpl
import com.hieuminh.jobfinder.views.activity.OnboardActivity
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class LoginFragment : BaseFragment<FragmentLoginBinding>(), LoginContract.View {
    private var mNavigator: OnBoardingNavigator? = null
    private var mPresenter: LoginContract.Presenter? = null

    private val signUpClickListener = View.OnClickListener {
        mNavigator?.startToRegister()
    }

    private val signInClickListener = View.OnClickListener {
        mPresenter?.login(binding?.evEmail?.text ?: "", binding?.evPassword?.text ?: "")
    }

    private val forgotPasswordClickListener = View.OnClickListener {
        mNavigator?.startToForgotPassword()
    }

    override fun getViewBinding() = FragmentLoginBinding.inflate(layoutInflater)

    override fun onLoginSuccess(loginRes: LoginRes) {
        mNavigator?.startMainActivity()
    }

    override fun onFailure(errorMessage: String, code: Int?) {
    }

    override fun initListener() {
        binding?.tvSignUp?.setOnClickListener(signUpClickListener)
        binding?.tvForgotPassword?.setOnClickListener(forgotPasswordClickListener)
        binding?.btSubmit?.setOnClickListener(signInClickListener)
    }

    override fun initView() {
        mNavigator = (activity as? OnboardActivity)?.getNavigator(binding?.root)
        mPresenter = LoginContractImpl(this)
    }
}
