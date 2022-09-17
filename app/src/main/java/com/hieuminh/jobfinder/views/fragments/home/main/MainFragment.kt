package com.hieuminh.jobfinder.views.fragments.home.main

import com.hieuminh.jobfinder.common.extensions.ViewExtensions.navController
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.onClick
import com.hieuminh.jobfinder.databinding.FragmentMainBinding
import com.hieuminh.jobfinder.models.Job
import com.hieuminh.jobfinder.models.Skill
import com.hieuminh.jobfinder.models.Tip
import com.hieuminh.jobfinder.views.adapter.JobAdapter
import com.hieuminh.jobfinder.views.adapter.SkillAdapter
import com.hieuminh.jobfinder.views.adapter.base.BaseAdapter
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>() {
    private lateinit var skillAdapter: SkillAdapter
    private lateinit var jobAdapter: JobAdapter
    private val tipList = arrayOf(Tip(), Tip(), Tip(), Tip(), Tip(), Tip())

    override fun getViewBinding() = FragmentMainBinding.inflate(layoutInflater)

    override fun initListener() {
        binding.ivNotification.onClick {
            view?.navController?.navigate(MainFragmentDirections.actionMainFragmentToNotificationFragment())
        }
        binding.tvSeeAllTips.onClick {
            view?.navController?.navigate(MainFragmentDirections.actionMainFragmentToTipPageFragment(tipList))
        }
//        binding.tvSeeJobs.onClick {
//            view?.navController?.navigate(MainFragmentDirections.actionMainFragmentToJobSearchFragment())
//        }
        binding.itemTip.tvReadMore.onClick {
            view?.navController?.navigate(MainFragmentDirections.actionMainFragmentToTipDetailFragment(tipList.first()))
        }
    }

    override fun initView() {
        val skillItemListener = object : BaseAdapter.ItemEventListener<Skill> {
            override fun onItemClick(item: Skill, position: Int) {
                item.isSelected = !item.isSelected
                skillAdapter.notifyItemChanged(position)
            }
        }
        skillAdapter = SkillAdapter().apply {
            updateData(
                mutableListOf(
                    Skill("asdfs"),
                    Skill("asdfs"),
                    Skill("asdfs"),
                    Skill("asdfs"),
                )
            )
            setItemListener(skillItemListener)
        }
        binding.rvJobRecommendation.adapter = skillAdapter

        val jobRecommendationItemListener = object : BaseAdapter.ItemEventListener<Job> {
            override fun onItemClick(item: Job, position: Int) {
//                view?.navController?.navigate(MainFragmentDirections.actionMainFragmentToJobDetailFragment(item))
            }
        }
        jobAdapter = JobAdapter().apply {
            setItemListener(jobRecommendationItemListener)
            updateData(
                mutableListOf(
                    Job(),
                    Job(),
                    Job(),
                    Job(),
                    Job(),
                    Job(),
                    Job(),
                    Job(),
                    Job(),
                )
            )
        }
        binding.rvJobList.adapter = jobAdapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
