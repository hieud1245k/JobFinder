package com.hieuminh.jobfinder.views.fragments

import com.hieuminh.jobfinder.R
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.gone
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.onClick
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.visible
import com.hieuminh.jobfinder.databinding.FragmentForgotPasswordBinding
import com.hieuminh.jobfinder.models.response.LoginRes
import com.hieuminh.jobfinder.navigators.ResetPasswordNavigator
import com.hieuminh.jobfinder.navigators.ResetPasswordNavigatorImpl
import com.hieuminh.jobfinder.presenters.UserContracts
import com.hieuminh.jobfinder.presenters.impl.UserPresenterImpl
import com.hieuminh.jobfinder.views.fragments.base.BaseAdvanceFragment

class ForgotPasswordFragment : BaseAdvanceFragment<
        ResetPasswordNavigator,
        UserContracts.ResetPasswordContract.Presenter,
        FragmentForgotPasswordBinding>(), UserContracts.ResetPasswordContract.View {
    private var userId: Int? = null

    private val isEmailVerified: Boolean
        get() = userId != null

    override fun getViewBinding() = FragmentForgotPasswordBinding.inflate(layoutInflater)

    override fun getPresenter() = UserPresenterImpl.ResetPasswordPresenterImpl(this)

    override fun getNavigator() = ResetPasswordNavigatorImpl(view)

    override fun resetPasswordSuccessful(loginRes: LoginRes) {
    }

    override fun verifyEmailSuccess(userId: Int) {
        this.userId = userId
        binding?.btSubmit?.text = resources.getString(R.string.reset_password)
        binding?.tvVerifiedEmailMessage?.text = String.format(
            resources.getString(R.string.your_email_s_is_verified),
            binding?.evEmail?.text,
        )

        binding?.evEmail?.gone()
        binding?.llInputNewPassword?.visible()
    }

    override fun onFailure(errorMessage: String, code: Int?) {
    }

    private fun resetPassword() {

    }

    private fun verifyEmail() {
        mPresenter?.verifyEmail(binding?.evEmail?.text ?: return)
    }

    override fun initListener() {
        binding?.btSubmit?.onClick { if (isEmailVerified) resetPassword() else verifyEmail() }
    }

    override fun initView() {
    }
}
