package com.hieuminh.jobfinder.navigators

import android.content.Intent
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.hieuminh.jobfinder.views.activity.InitProfileActivity
import com.hieuminh.jobfinder.views.activity.MainActivity
import com.hieuminh.jobfinder.views.fragments.ActiveAccountFragmentDirections
import com.hieuminh.jobfinder.views.fragments.LoginFragmentDirections
import com.hieuminh.jobfinder.views.fragments.RegisterFragmentDirections

interface OnBoardingNavigator: LoginNavigator {
    fun startToForgotPassword()
    fun backToLogin()
    fun startMainActivity()
    fun startActiveAccount(email: String)
    fun startToInitProfile()
    fun startToActiveAccountSuccessful()
}

interface LoginNavigator {
    fun startToRegister()
    fun startActiveAccountFromLogin(email: String)
}

class OnBoardingNavigatorImpl(private val view: View?) : OnBoardingNavigator {
    private val navController: NavController? = view?.let { Navigation.findNavController(it) }
    override fun startToRegister() {
        val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
        navController?.navigate(action)
    }

    override fun startActiveAccountFromLogin(email: String) {
        val action = LoginFragmentDirections.actionLoginFragmentToActiveAccountFragment(email)
        navController?.navigate(action)
    }

    override fun startToForgotPassword() {
        val action = LoginFragmentDirections.actionOnboardFragmentToForgotPasswordFragment()
        navController?.navigate(action)
    }

    override fun backToLogin() {
        navController?.popBackStack()
    }

    override fun startMainActivity() {
        val intent = Intent(view?.context, MainActivity::class.java)
        view?.context?.startActivity(intent)
    }

    override fun startActiveAccount(email: String) {
        val action = RegisterFragmentDirections.actionRegisterFragmentToActiveAccountFragment(email)
        navController?.navigate(action)
    }

    override fun startToInitProfile() {
        val intent = Intent(view?.context, InitProfileActivity::class.java)
        view?.context?.startActivity(intent)
    }

    override fun startToActiveAccountSuccessful() {
        val action = ActiveAccountFragmentDirections
            .actionActiveAccountFragmentToActiveAccountSccessfulFragment()
        navController?.navigate(action)
    }
}
