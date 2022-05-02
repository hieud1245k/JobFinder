package com.hieuminh.jobfinder.views.fragments

import android.view.View
import com.hieuminh.jobfinder.databinding.FragmentOnboardBinding
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class OnboardFragment : BaseFragment<FragmentOnboardBinding>() {
    override fun getViewBinding() = FragmentOnboardBinding.inflate(layoutInflater)

    private val loginWithFacebookClickListener = View.OnClickListener {

    }

    private val loginWithGoogleClickListener = View.OnClickListener {

    }

    override fun initListener() {
        binding?.llLoginWithFacebook?.setOnClickListener(loginWithFacebookClickListener)
        binding?.llLoginWithGoogle?.setOnClickListener(loginWithGoogleClickListener)
    }

    override fun initView() {
    }

}
