package com.hieuminh.jobfinder.views.customs.base

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.viewbinding.ViewBinding
import com.hieuminh.jobfinder.interfaces.InitLayout

abstract class BaseLinearLayout<VBinding: ViewBinding>(context: Context?, attrs: AttributeSet?) :
    LinearLayout(context, attrs), InitLayout<VBinding> {
    protected var binding: VBinding? = null
        private set

    init {
        init()
    }

    private fun init() {
        binding = getViewBinding()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        initView()
        initListener()
    }

    override fun initView() = Unit
}
