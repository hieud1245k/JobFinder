package com.hieuminh.jobfinder.views.fragments.home.main

import android.os.Bundle
import com.hieuminh.jobfinder.databinding.FragmentTipDetailBinding
import com.hieuminh.jobfinder.models.Tip
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class TipDetailFragment : BaseFragment<FragmentTipDetailBinding>() {
    private lateinit var tip: Tip

    override fun getViewBinding() = FragmentTipDetailBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val args = TipDetailFragmentArgs.fromBundle(it)
            tip = args.tip
        }
    }

    override fun initListener() {
    }

    override fun initView() {
        binding.tvTitle.text = tip.title
        binding.tvViewTitle.text = tip.title
        binding.tvAuthorName.text = tip.authorName
        binding.tvAuthorPosition.text = tip.authorPosition
        binding.tvContent.text = tip.content
    }

    companion object {
        @JvmStatic
        fun newInstance() = TipDetailFragment()
    }
}
