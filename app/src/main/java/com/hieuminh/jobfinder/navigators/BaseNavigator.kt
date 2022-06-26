package com.hieuminh.jobfinder.navigators

import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation

open class BaseNavigator(private val view: View?) {
    protected val navController: NavController? = view?.let { Navigation.findNavController(it) }
}