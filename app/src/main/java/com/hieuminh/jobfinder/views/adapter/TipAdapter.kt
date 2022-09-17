package com.hieuminh.jobfinder.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.onClick
import com.hieuminh.jobfinder.databinding.ItemTipBinding
import com.hieuminh.jobfinder.models.Tip
import com.hieuminh.jobfinder.views.adapter.base.BaseAdapter

class TipAdapter : BaseAdapter<Tip>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return TipViewHolder(ItemTipBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    inner class TipViewHolder(private val binding: ItemTipBinding) : BaseViewHolder(binding.root) {
        init {
            itemView.setOnClickListener(null)
            binding.tvReadMore.onClick {
                itemEventListener?.onItemClick(dataList[layoutPosition], layoutPosition)
            }
        }

        override fun bind(data: Tip) {
        }
    }
}
