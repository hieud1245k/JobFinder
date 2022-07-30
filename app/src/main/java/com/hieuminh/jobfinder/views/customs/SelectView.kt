package com.hieuminh.jobfinder.views.customs

import android.content.Context
import android.util.AttributeSet
import com.hieuminh.jobfinder.R
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.onClick
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.toTextView

class SelectView(context: Context?, attrs: AttributeSet?) : EditView(context, attrs) {
    private var provinces = listOf("Quang Nam", "Da Nang", "Ha Noi", "Ho Chi Minh", "Quang Ngai", "Binh Dinh")

    init {
        suffixIconSrc = R.drawable.ic_drop_down
    }

    private fun showSelectOptionsDropdown() {

    }

    override fun initListener() {
        super.initListener()
        binding?.llInputData?.onClick { showSelectOptionsDropdown() }
    }

    override fun initView() {
        super.initView()
        binding?.etInputData?.toTextView()
    }
}