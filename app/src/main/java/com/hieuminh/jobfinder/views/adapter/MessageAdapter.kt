package com.hieuminh.jobfinder.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hieuminh.jobfinder.databinding.ItemReceiveMessageBinding
import com.hieuminh.jobfinder.databinding.ItemSendMessageBinding
import com.hieuminh.jobfinder.models.Message
import com.hieuminh.jobfinder.views.adapter.base.BaseAdapter

class MessageAdapter(private val userId: Int) : BaseAdapter<Message>() {
    override fun getItemViewType(position: Int): Int {
        return if (userId == dataList[position].id) ViewType.SEND.ordinal else ViewType.RECEIVE.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        if (viewType == ViewType.SEND.ordinal) {
            return SendMessageViewHolder(ItemSendMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
        return ReceiveMessageViewHolder(ItemReceiveMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    inner class SendMessageViewHolder(private val binding: ItemSendMessageBinding) : BaseViewHolder(binding.root) {
        override fun bind(data: Message) {
            binding.tvMessage.text = data.message
        }
    }

    inner class ReceiveMessageViewHolder(private val binding: ItemReceiveMessageBinding) : BaseViewHolder(binding.root) {
        override fun bind(data: Message) {
            binding.tvMessage.text = data.message
        }
    }

    enum class ViewType {
        SEND,
        RECEIVE,
    }
}
