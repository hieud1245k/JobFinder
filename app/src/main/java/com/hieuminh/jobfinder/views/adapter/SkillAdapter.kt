package com.hieuminh.jobfinder.views.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hieuminh.jobfinder.R
import com.hieuminh.jobfinder.databinding.ItemJobRecommendationBinding
import com.hieuminh.jobfinder.models.Skill
import com.hieuminh.jobfinder.views.adapter.base.BaseAdapter

class SkillAdapter : BaseAdapter<Skill>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return SkillViewHolder(ItemJobRecommendationBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    inner class SkillViewHolder(val binding: ItemJobRecommendationBinding) : BaseViewHolder(binding.root) {
        override fun bind(data: Skill) {
            binding.tvName.text = data.name
            binding.tvName.backgroundTintList =
                if (data.isSelected) ColorStateList.valueOf(context.resources.getColor(R.color.colorPrimary, null)) else null
            binding.tvName.setTextColor(context.resources.getColor(if (data.isSelected) R.color.white else R.color.colorPrimary, null))
        }
    }
}
