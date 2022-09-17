package com.hieuminh.jobfinder.views.fragments.home.main

import com.hieuminh.jobfinder.common.extensions.ViewExtensions.navController
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.onClick
import com.hieuminh.jobfinder.databinding.FragmentMainBinding
import com.hieuminh.jobfinder.models.Job
import com.hieuminh.jobfinder.models.Skill
import com.hieuminh.jobfinder.models.Tip
import com.hieuminh.jobfinder.presenters.TipContract
import com.hieuminh.jobfinder.presenters.impl.TipPresenterImpl
import com.hieuminh.jobfinder.views.adapter.JobAdapter
import com.hieuminh.jobfinder.views.adapter.SkillAdapter
import com.hieuminh.jobfinder.views.adapter.base.BaseAdapter
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>(), TipContract.View {
    private lateinit var skillAdapter: SkillAdapter
    private lateinit var jobAdapter: JobAdapter
    private lateinit var tipPresenter: TipContract.Presenter

    private var tipList: ArrayList<Tip> = arrayListOf()

    override fun getViewBinding() = FragmentMainBinding.inflate(layoutInflater)

    override fun onSuccess(tipList: ArrayList<Tip>) {
        this.tipList = tipList
        binding.itemTip.tvTitle.text = tipList.firstOrNull()?.title
    }

    override fun onFailure(errorMessage: String, code: Int?) {
        print(errorMessage)
    }

    override fun initListener() {
        binding.ivNotification.onClick {
            view?.navController?.navigate(MainFragmentDirections.actionMainFragmentToNotificationFragment())
        }
        binding.tvSeeAllTips.onClick {
            if (tipList.isNotEmpty()) {
                view?.navController?.navigate(MainFragmentDirections.actionMainFragmentToTipPageFragment(tipList.toTypedArray()))
            }
        }
//        binding.tvSeeJobs.onClick {
//            view?.navController?.navigate(MainFragmentDirections.actionMainFragmentToJobSearchFragment())
//        }
        binding.itemTip.tvReadMore.onClick {
            val firstTip = tipList.firstOrNull() ?: return@onClick
            view?.navController?.navigate(MainFragmentDirections.actionMainFragmentToTipDetailFragment(firstTip))
        }
    }

    private fun initData() {
        tipPresenter = TipPresenterImpl(this)
        skillAdapter = SkillAdapter().apply {
            updateData(
                mutableListOf(
                    Skill("asdfs"),
                    Skill("asdfs"),
                    Skill("asdfs"),
                    Skill("asdfs"),
                )
            )
            setItemListener(object : BaseAdapter.ItemEventListener<Skill> {
                override fun onItemClick(item: Skill, position: Int) {
                    item.isSelected = !item.isSelected
                    skillAdapter.notifyItemChanged(position)
                }
            })
        }
        jobAdapter = JobAdapter().apply {
            updateData(List(5) { Job() }.toMutableList())
        }
    }

    override fun initView() {
        initData()

        binding.rvJobRecommendation.adapter = skillAdapter
        binding.rvJobList.adapter = jobAdapter

        tipPresenter.getTipList()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
