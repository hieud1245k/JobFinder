package com.hieuminh.jobfinder.views.activity.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import com.hieuminh.jobfinder.R
import com.hieuminh.jobfinder.interfaces.BaseViewEvent
import com.hieuminh.jobfinder.interfaces.InitLayout
import com.hieuminh.jobfinder.presenters.base.BaseView

abstract class BaseActivity<VBinding : ViewBinding> : AppCompatActivity(), InitLayout<VBinding>, BaseViewEvent {
    lateinit var binding: VBinding
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        initView()
        initListener()
    }

    override fun onBackPressed() {
        try {
            if (!Navigation.findNavController(this,R.id.nav_onboard_fragments).popBackStack()) {
                super.onBackPressed()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onConnectInternetFailure() {
    }
}
