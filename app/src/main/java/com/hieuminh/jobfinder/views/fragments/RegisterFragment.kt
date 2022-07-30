package com.hieuminh.jobfinder.views.fragments

import android.app.AlertDialog
import android.view.View
import com.hieuminh.jobfinder.databinding.FragmentRegisterBinding
import com.hieuminh.jobfinder.navigators.OnBoardingNavigator
import com.hieuminh.jobfinder.navigators.OnBoardingNavigatorImpl
import com.hieuminh.jobfinder.presenters.UserContracts
import com.hieuminh.jobfinder.presenters.impl.UserPresenterImpl
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class RegisterFragment : BaseFragment<FragmentRegisterBinding>(), UserContracts.RegisterContract.View {
    private var mNavigator: OnBoardingNavigator? = null
    private var mRegisterPresenter: UserContracts.RegisterContract.Presenter? = null

    override fun getViewBinding() = FragmentRegisterBinding.inflate(layoutInflater)

    private val signInClickListener = View.OnClickListener {
        mNavigator?.backToLogin()
    }

    private val registerClickListener = View.OnClickListener {
        val email = binding?.evEmail?.text?.toString() ?: ""
        val password = binding?.evPassword?.text?.toString() ?: ""
        mRegisterPresenter?.register(email, password)
    }

    private fun checkValid() {

    }

    override fun onRegisterSuccess() {
        mNavigator?.startActiveAccount(binding?.evEmail?.text?.toString() ?: "")
    }

    override fun onFailure(errorMessage: String, code: Int?) {
        when(code) {
            406 -> {
                mNavigator?.startActiveAccount(binding?.evEmail?.text?.toString() ?: "")
            }
            else -> {
                AlertDialog.Builder(context)
                    .setTitle("Notice!")
                    .setMessage(errorMessage)
                    .setPositiveButton("ok") { dialog, _ ->
                        dialog.dismiss()
                    }.show()
            }
        }
    }

    override fun initListener() {
        binding?.tvSignIn?.setOnClickListener(signInClickListener)
        binding?.btSubmit?.setOnClickListener(registerClickListener)
    }

    override fun initView() {
        mNavigator = OnBoardingNavigatorImpl(binding?.root)
        mRegisterPresenter = UserPresenterImpl.RegisterPresenterImpl(this)
    }
}
