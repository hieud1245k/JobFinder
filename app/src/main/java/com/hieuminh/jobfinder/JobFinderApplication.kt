package com.hieuminh.jobfinder

import android.app.Application
import com.hieuminh.jobfinder.utils.AppPreference

class JobFinderApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppPreference.setContext(applicationContext)
    }
}
