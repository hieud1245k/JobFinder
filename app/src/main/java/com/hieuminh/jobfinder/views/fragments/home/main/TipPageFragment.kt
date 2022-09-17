package com.hieuminh.jobfinder.views.fragments.home.main

import android.os.Bundle
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.navController
import com.hieuminh.jobfinder.databinding.FragmentTipPageBinding
import com.hieuminh.jobfinder.models.Tip
import com.hieuminh.jobfinder.views.adapter.TipAdapter
import com.hieuminh.jobfinder.views.adapter.base.BaseAdapter
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class TipPageFragment : BaseFragment<FragmentTipPageBinding>() {
    private lateinit var tipList: ArrayList<Tip>

    override fun getViewBinding() = FragmentTipPageBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val args = TipPageFragmentArgs.fromBundle(requireArguments())
            tipList = args.tipList.toList() as? ArrayList<Tip> ?: arrayListOf()
        }
    }

    override fun initListener() {
    }

    override fun initView() {
        val tipItemListener = object : BaseAdapter.ItemEventListener<Tip> {
            override fun onItemClick(item: Tip, position: Int) {
                navController?.navigate(TipPageFragmentDirections.actionTipPageFragmentToTipDetailFragment(item))
            }
        }
        binding.rvTipList.adapter = TipAdapter().apply {
            updateData(tipList)
            setItemListener(tipItemListener)
        }
    }
}
