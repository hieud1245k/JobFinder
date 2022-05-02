package com.hieuminh.jobfinder.navigators

import android.app.Activity
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation

interface OnBoardingNavigator {
    fun startToRegister()
    fun backToLogin()
}

class OnBoardingNavigatorImpl(view: View?) : OnBoardingNavigator {
    private val navController: NavController? = view?.let { Navigation.findNavController(it) }
    override fun startToRegister() {
        TODO("Not yet implemented")
    }

    override fun backToLogin() {
        TODO("Not yet implemented")
    }

}
