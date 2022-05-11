package com.hieuminh.jobfinder.utils

import android.content.Context
import com.hieuminh.jobfinder.common.constants.StringConstant

class AppPreference(private val context: Context?) {
    private val pref = context?.getSharedPreferences(StringConstant.PREF_NAME, 0)
    private val prefEditor = pref?.edit()

    var isRememberMe: Boolean
        set(value) {
            prefEditor?.putBoolean(StringConstant.IS_REMEMBER_ME, value)?.commit()
        }
        get() = pref?.getBoolean(StringConstant.IS_REMEMBER_ME, false) ?: false

    var accessToken: String?
        set(value) {
            prefEditor?.putString(StringConstant.ACCESS_TOKEN, value)?.commit()
        }
        get() = pref?.getString(StringConstant.ACCESS_TOKEN, null)

    companion object {
        private var appPreference: AppPreference? = null
        private var context: Context? = null

        fun setContext(context: Context?) {
            this.context = context
        }

        val instance: AppPreference
            get() = appPreference ?: AppPreference(context)
    }
}


