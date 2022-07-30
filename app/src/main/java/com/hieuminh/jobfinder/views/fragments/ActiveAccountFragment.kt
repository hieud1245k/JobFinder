package com.hieuminh.jobfinder.views.fragments

import android.os.Bundle
import android.os.CountDownTimer
import com.hieuminh.jobfinder.R
import com.hieuminh.jobfinder.common.extensions.StringExtensions.toSafeInt
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.gone
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.onClick
import com.hieuminh.jobfinder.databinding.FragmentActiveAccountBinding
import com.hieuminh.jobfinder.models.response.LoginRes
import com.hieuminh.jobfinder.navigators.OnBoardingNavigator
import com.hieuminh.jobfinder.navigators.OnBoardingNavigatorImpl
import com.hieuminh.jobfinder.presenters.UserContracts
import com.hieuminh.jobfinder.presenters.impl.UserPresenterImpl
import com.hieuminh.jobfinder.views.customs.InputCodeLayout
import com.hieuminh.jobfinder.views.fragments.base.BaseAdvanceFragment

class ActiveAccountFragment : BaseAdvanceFragment<
        OnBoardingNavigator,
        UserContracts.ActiveUserContract.Presenter,
        FragmentActiveAccountBinding
        >(),
    UserContracts.ActiveUserContract.View, InputCodeLayout.InputCodeListener {
    private var mEmail: String? = null

    override fun getViewBinding() = FragmentActiveAccountBinding.inflate(layoutInflater)

    override fun getPresenter() = UserPresenterImpl.ActiveUserPresenterImpl(this)

    override fun getNavigator() = OnBoardingNavigatorImpl(view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = ActiveAccountFragmentArgs.fromBundle(requireArguments())
        mEmail = args.email
    }

    override fun onResume() {
        var timer: CountDownTimer? = null
        timer = object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                try {
                    binding?.tvResendCodeIn?.text = String.format(
                        resources.getString(R.string.resend_code_in_s_s),
                        millisUntilFinished / 1000,
                    )
                } catch (e: Exception) {
                    timer?.cancel()
                }
            }

            override fun onFinish() {

            }
        }
        timer.start()
        super.onResume()
    }

    override fun activeUserSuccess(loginRes: LoginRes?) {
        mNavigator?.startToActiveAccountSuccessful()
    }

    override fun onFailure(errorMessage: String, code: Int?) {
        print("dsnfkds")
    }

    override fun inputCodeCompleted(code: String) {
        mPresenter?.sendActiveCode(mEmail ?: "", code.toSafeInt())
    }

    private fun activeUser() {

    }

    override fun initListener() {
        binding?.btSubmit?.onClick(::activeUser)
        binding?.layoutInputCode?.setInputCodeListener(this)
    }

    override fun initView() {
        binding?.llHeader?.title = resources.getString(R.string.active_account)
        binding?.btSubmit?.text = resources.getString(R.string.active)
        binding?.layoutError?.root?.gone()
        binding?.tvSendCodeToEmail?.text = String.format(
            resources.getString(R.string.code_has_been_send_to_s),
            mEmail,
        )
    }
}