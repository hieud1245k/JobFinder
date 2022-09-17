package com.hieuminh.jobfinder.views.customs.header

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.hieuminh.jobfinder.R
import com.hieuminh.jobfinder.databinding.LayoutHeaderActionViewBinding
import com.hieuminh.jobfinder.views.customs.base.BaseLinearLayout

class HeaderActionView(context: Context, attrs: AttributeSet) : BaseLinearLayout<LayoutHeaderActionViewBinding>(context, attrs) {
    init {
        context.obtainStyledAttributes(attrs, R.styleable.HeaderActionView, 0, 0).run {
            try {
                binding?.tvTitle?.text = getString(R.styleable.HeaderActionView_android_text)
                binding?.ivActionIcon?.setImageResource(getResourceId(R.styleable.HeaderActionView_actionIconSrc, 0))
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                recycle()
            }
        }
    }

    override fun getViewBinding() = LayoutHeaderActionViewBinding.inflate(LayoutInflater.from(context), this, true)

    override fun initListener() {
    }
}
