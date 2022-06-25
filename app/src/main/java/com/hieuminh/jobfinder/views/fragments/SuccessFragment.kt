package com.hieuminh.jobfinder.views.fragments

import com.bumptech.glide.Glide
import com.hieuminh.jobfinder.R
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.onClick
import com.hieuminh.jobfinder.databinding.FragmentSuccessBinding
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

abstract class SuccessFragment : BaseFragment<FragmentSuccessBinding>() {
    override fun getViewBinding() = FragmentSuccessBinding.inflate(layoutInflater)

    abstract fun openToPage()

    override fun initListener() {
        binding?.tvContinue?.onClick(::openToPage)
    }

    override fun initView() {
        binding?.ivSuccessIcon?.let {
            Glide.with(this)
                .load(R.drawable.ic_success_dynamic)
                .into(it)
        }
    }
}