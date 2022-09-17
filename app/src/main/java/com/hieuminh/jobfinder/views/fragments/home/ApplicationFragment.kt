package com.hieuminh.jobfinder.views.fragments.home

import com.hieuminh.jobfinder.common.enums.JobStateType
import com.hieuminh.jobfinder.databinding.FragmentApplicationBinding
import com.hieuminh.jobfinder.models.Application
import com.hieuminh.jobfinder.models.base.BaseChipModel
import com.hieuminh.jobfinder.views.adapter.ApplicationAdapter
import com.hieuminh.jobfinder.views.adapter.ChipAdapter
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class ApplicationFragment : BaseFragment<FragmentApplicationBinding>() {

    override fun getViewBinding() = FragmentApplicationBinding.inflate(layoutInflater)

    override fun initListener() {
    }

    override fun initView() {
        binding.rvJobStatusList.adapter = ChipAdapter().apply {
            updateData(JobStateType.values().map { BaseChipModel(it.name) }.toMutableList())
        }
        binding.rvApplicationList.adapter = ApplicationAdapter().apply {
            updateData(List(5) { Application() }.toMutableList())
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ApplicationFragment()
    }
}
