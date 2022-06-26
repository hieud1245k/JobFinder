package com.hieuminh.jobfinder.navigators

import android.content.Intent
import android.view.View
import com.hieuminh.jobfinder.views.activity.MainActivity

interface ResetPasswordNavigator {
    fun startToMainActivity()
}

class ResetPasswordNavigatorImpl(private val view: View?) : BaseNavigator(view), ResetPasswordNavigator {
    override fun startToMainActivity() {
        val intent = Intent(view?.context, MainActivity::class.java)
        view?.context?.startActivity(intent)
    }
}