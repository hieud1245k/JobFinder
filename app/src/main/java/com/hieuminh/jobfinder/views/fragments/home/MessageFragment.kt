package com.hieuminh.jobfinder.views.fragments.home

import androidx.recyclerview.widget.LinearLayoutManager
import com.hieuminh.jobfinder.databinding.FragmentMessageBinding
import com.hieuminh.jobfinder.models.Message
import com.hieuminh.jobfinder.views.adapter.MessageAdapter
import com.hieuminh.jobfinder.views.fragments.base.BaseFragment

class MessageFragment : BaseFragment<FragmentMessageBinding>() {
    private lateinit var messageAdapter: MessageAdapter

    private val messages = listOf(
        Message("sanfsjknfdsjkdfsdjkbf", fromUserId = 1, toUserId = 0),
        Message("sanfsjknfdsjkdfsdjkbf", fromUserId = 1, toUserId = 0),
        Message("sanfsjknfdsjkdfsdjkbf", fromUserId = 1, toUserId = 0),
        Message("sanfsjknfdsjkdfsdjkbf", fromUserId = 1, toUserId = 0),
        Message("sanfsjknfdsjkdfsdjkbf", fromUserId = 1, toUserId = 0),
        Message("sanfsjknfdsjkdfsdjkbf", fromUserId = 1, toUserId = 0),
        Message("sanfsjknfdsjkdfsdjkbf", fromUserId = 1, toUserId = 0),
        Message("sanfsjknfdsjkdfsdjkbf", fromUserId = 1, toUserId = 0),
        Message("sanfsjknfdsjkdfsdjkbf", fromUserId = 1, toUserId = 0),
        Message("sanfsjknfdsjkdfsdjkbf", fromUserId = 1, toUserId = 0),
        Message("sanfsjknfdsjkdfsdjkbf", fromUserId = 1, toUserId = 0),
        Message("sanfsjknfdsjkdfsdjkbf", fromUserId = 1, toUserId = 0),
        Message("sanfsjknfdsjkdfsdjkbf", fromUserId = 1, toUserId = 0),
        Message("sanfsjknfdsjkdfsdjkbf", fromUserId = 1, toUserId = 0),
        Message("sanfsjknfdsjkdfsdjkbf", fromUserId = 1, toUserId = 0),
        Message("sanfsjknfdsjkdfsdjkbf", fromUserId = 1, toUserId = 0),
        Message("sanfsjknfdsjkdfsdjkbf", fromUserId = 1, toUserId = 0),
        Message("sanfsjknfdsjkdfsdjkbf", fromUserId = 1, toUserId = 0),
        Message("sanfsjknfdsjkdfsdjkbf", fromUserId = 1, toUserId = 0),
        Message("sanfsjknfdsjkdfsdjkbf", fromUserId = 1, toUserId = 0),
        Message("sanfsjknfdsjkdfsdjkbf", fromUserId = 1, toUserId = 0),
    )

    override fun getViewBinding() = FragmentMessageBinding.inflate(layoutInflater)

    private fun initRecyclerViewAdapter() {
        messageAdapter = MessageAdapter(0)
        messageAdapter.updateData(messages.toMutableList())
        binding.rvMessage.adapter = messageAdapter
        (binding.rvMessage.layoutManager as? LinearLayoutManager)?.reverseLayout = true
    }

    override fun initListener() {
    }

    override fun initView() {
        initRecyclerViewAdapter()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MessageFragment()
    }
}
