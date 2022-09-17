package com.hieuminh.jobfinder.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hieuminh.jobfinder.databinding.ItemJobRecommendationBinding
import com.hieuminh.jobfinder.models.base.BaseChipModel
import com.hieuminh.jobfinder.views.adapter.base.BaseAdapter

class ChipAdapter : BaseAdapter<BaseChipModel>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ChipViewHolder(ItemJobRecommendationBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    inner class ChipViewHolder(private val binding: ItemJobRecommendationBinding) : BaseViewHolder(binding.root) {
        override fun bind(data: BaseChipModel) {
            binding.tvName.text = data.name
        }
    }
}
