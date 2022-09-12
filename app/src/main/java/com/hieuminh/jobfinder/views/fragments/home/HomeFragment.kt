package com.hieuminh.jobfinder.views.fragments.home

import android.view.LayoutInflater
import android.widget.LinearLayout
import com.hieuminh.jobfinder.common.enums.TabLayoutType
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.gone
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.onClick
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.visible
import com.hieuminh.jobfinder.databinding.FragmentHomeBinding
import com.hieuminh.jobfinder.databinding.ItemTabViewBinding
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment


class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private var currentTab = TabLayoutType.HOME

    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)

    private fun addTabView() {
        TabLayoutType.values().forEachIndexed { index, tabType ->
            val itemTabBinding = ItemTabViewBinding.inflate(LayoutInflater.from(context))
            itemTabBinding.ivTabIcon.setImageResource(tabType.iconResId)
            val layoutParam = if (currentTab == tabType) {
                itemTabBinding.tvTabName.setText(tabType.nameResId)
                LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f)
            } else {
                LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT)
            }
            layoutParam.setMargins(if (index != 0) 24 else 0, 0, 0, 0)
            itemTabBinding.root.layoutParams = layoutParam
            itemTabBinding.root.onClick {
                if (currentTab != tabType) {
                    currentTab = tabType
                    binding.llTabLayout.removeAllViews()
                    addTabView()
                }
            }
            binding.llTabLayout.addView(itemTabBinding.root)
        }
    }

    override fun initListener() {
    }

    override fun initView() {
        addTabView()
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
