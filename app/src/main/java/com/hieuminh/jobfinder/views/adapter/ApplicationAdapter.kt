package com.hieuminh.jobfinder.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hieuminh.jobfinder.databinding.ItemApplicationBinding
import com.hieuminh.jobfinder.models.Application
import com.hieuminh.jobfinder.views.adapter.base.BaseAdapter

class ApplicationAdapter : BaseAdapter<Application>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ApplicationViewHolder(ItemApplicationBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    inner class ApplicationViewHolder(private val binding: ItemApplicationBinding) : BaseViewHolder(binding.root) {
        override fun bind(data: Application) {
        }
    }
}
