package com.hieuminh.jobfinder.views.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.text.InputType
import android.view.View
import com.hieuminh.jobfinder.R
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
        mPresenter?.login(
            binding?.evEmail?.text ?: "",
            binding?.evPassword?.text ?: "",
        )
    }

    private val forgotPasswordClickListener = View.OnClickListener {
        mNavigator?.startToForgotPassword()
    }

    private val togglePasswordStateListener = View.OnClickListener {
        val passwordView = binding?.evPassword?.sourceView
        val passwordStateIcon = binding?.evPassword?.suffixIcon
        if (passwordView?.inputType == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
            passwordView.inputType =
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            passwordStateIcon?.setImageResource(R.drawable.ic_eye_hidden)
        } else {
            passwordView?.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            passwordStateIcon?.setImageResource(R.drawable.ic_eye_open)
        }
    }

    override fun getViewBinding() = FragmentLoginBinding.inflate(layoutInflater)

    override fun onLoginSuccess(loginRes: LoginRes) {
        mNavigator?.startMainActivity()
    }

    override fun onFailure(errorMessage: String, code: Int?) {
        AlertDialog.Builder(context)
            .setTitle("Notice")
            .setMessage(errorMessage)
            .setPositiveButton("ok") { dialog, _ ->
                dialog.dismiss()
            }.show()
    }

    override fun initListener() {
        binding?.tvSignUp?.setOnClickListener(signUpClickListener)
        binding?.tvForgotPassword?.setOnClickListener(forgotPasswordClickListener)
        binding?.btSubmit?.setOnClickListener(signInClickListener)
        binding?.evPassword?.suffixIcon?.setOnClickListener(togglePasswordStateListener)
    }

    override fun initView() {
        mNavigator = (activity as? OnboardActivity)?.getNavigator(binding?.root)
        mPresenter = LoginContractImpl(this)

        binding?.evPassword?.sourceView?.inputType =
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
    }
}
