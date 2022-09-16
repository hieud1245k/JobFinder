package com.hieuminh.jobfinder.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hieuminh.jobfinder.databinding.ItemJobBinding
import com.hieuminh.jobfinder.models.Job
import com.hieuminh.jobfinder.views.adapter.base.BaseAdapter

class JobAdapter : BaseAdapter<Job>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return JobViewHolder(ItemJobBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    inner class JobViewHolder(private val binding: ItemJobBinding) : BaseViewHolder(binding.root) {
        override fun bind(data: Job) {
        }
    }
}
