package com.hieuminh.jobfinder.views.fragments.home

import com.hieuminh.jobfinder.databinding.FragmentMainBinding
import com.hieuminh.jobfinder.models.Job
import com.hieuminh.jobfinder.models.Skill
import com.hieuminh.jobfinder.views.adapter.JobAdapter
import com.hieuminh.jobfinder.views.adapter.SkillAdapter
import com.hieuminh.jobfinder.views.adapter.base.BaseAdapter
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>() {
    private lateinit var skillAdapter: SkillAdapter
    private lateinit var jobAdapter: JobAdapter

    override fun getViewBinding() = FragmentMainBinding.inflate(layoutInflater)

    override fun initListener() {
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
                    Skill("asdfs"),
                    Skill("asdfs"),
                    Skill("asdfs"),
                    Skill("asdfs"),
                    Skill("asdfs"),
                    Skill("asdfs"),
                    Skill("asdfs"),
                )
            )
            setItemListener(skillItemListener)
        }
        binding.rvJobRecommendation.adapter = skillAdapter

        jobAdapter = JobAdapter().apply {
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
