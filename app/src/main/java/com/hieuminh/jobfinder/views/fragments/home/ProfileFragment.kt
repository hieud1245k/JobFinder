package com.hieuminh.jobfinder.views.fragments.home

import com.hieuminh.jobfinder.common.extensions.ViewExtensions.navController
import com.hieuminh.jobfinder.databinding.FragmentProfileBinding
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override fun getViewBinding() = FragmentProfileBinding.inflate(layoutInflater)

    override fun initListener() {
        binding.ivSetting.setOnClickListener {
            val settingAction = ProfileFragmentDirections.actionProfileFragment2ToSettingFragment()
            view?.navController?.navigate(settingAction)
        }
    }

    override fun initView() {
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}
