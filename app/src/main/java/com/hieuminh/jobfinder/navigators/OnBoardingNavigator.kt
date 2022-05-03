package com.hieuminh.jobfinder.navigators

import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.hieuminh.jobfinder.views.fragments.LoginFragmentDirections

interface OnBoardingNavigator {
    fun startToRegister()
    fun startToForgotPassword()
    fun backToLogin()
}

class OnBoardingNavigatorImpl(view: View?) : OnBoardingNavigator {
    private val navController: NavController? = view?.let { Navigation.findNavController(it) }
    override fun startToRegister() {
        val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
        navController?.navigate(action)
    }

    override fun startToForgotPassword() {
        val action = LoginFragmentDirections.actionOnboardFragmentToForgotPasswordFragment()
        navController?.navigate(action)
    }

    override fun backToLogin() {
        navController?.popBackStack()
    }
}
