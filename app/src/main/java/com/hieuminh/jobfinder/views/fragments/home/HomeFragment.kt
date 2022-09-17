package com.hieuminh.jobfinder.views.fragments.home

import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.hieuminh.jobfinder.common.enums.TabLayoutType
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.onClick
import com.hieuminh.jobfinder.databinding.FragmentHomeBinding
import com.hieuminh.jobfinder.databinding.ItemTabViewBinding
import com.hieuminh.jobfinder.views.adapter.HomePageAdapter
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment
import com.hieuminh.jobfinder.views.fragments.home.main.NavigatorMainFragment
import com.hieuminh.jobfinder.views.fragments.home.profile.ProfileSettingFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private var currentTab = TabLayoutType.HOME
    lateinit var pageViewMap: Map<TabLayoutType, Fragment>

    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)

    private fun addTabView(tabs: List<TabLayoutType>) {
        tabs.forEachIndexed { index, tabType ->
            val itemTabBinding = ItemTabViewBinding.inflate(LayoutInflater.from(context))
            itemTabBinding.ivTabIcon.setImageResource(tabType.iconResId)
            val layoutParam = if (currentTab == tabType) {
                itemTabBinding.tvTabName.setText(tabType.nameResId)
                LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f)
            } else {
                LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT)
            }
            layoutParam.setMargins(if (index != 0) 30 else 0, 0, 0, 0)
            itemTabBinding.root.layoutParams = layoutParam
            itemTabBinding.root.onClick {
                if (currentTab != tabType) {
                    currentTab = tabType
                    scrollToPage(index)
                    binding.llTabLayout.removeAllViews()
                    addTabView(tabs)
                }
            }
            binding.llTabLayout.addView(itemTabBinding.root)
        }
    }

    private fun scrollToPage(page: Int) {
        binding.viewPager.setCurrentItem(page, true)
    }

    override fun initListener() {
    }

    override fun initView() {
        pageViewMap = mapOf(
            TabLayoutType.HOME to NavigatorMainFragment(),
            TabLayoutType.APPLICATIONS to ApplicationFragment(),
            TabLayoutType.CHAT to MessageFragment(),
            TabLayoutType.PROFILE to ProfileSettingFragment(),
        )
        addTabView(pageViewMap.keys.toList())
        binding.viewPager.run {
            adapter = HomePageAdapter(pageViewMap.values.toList(), this@HomeFragment)
            isUserInputEnabled = false
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
