package com.hieuminh.jobfinder.views.customs

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import com.hieuminh.jobfinder.R
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.navController
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.onClick
import com.hieuminh.jobfinder.databinding.ItemHeaderViewBinding
import com.hieuminh.jobfinder.views.customs.base.BaseLinearLayout

class HeaderView(context: Context, attrs: AttributeSet) : BaseLinearLayout<ItemHeaderViewBinding>(context, attrs) {
    override fun getViewBinding() = ItemHeaderViewBinding.inflate(LayoutInflater.from(context), this, true)

    var title: String?
        get() = binding?.tvTitle?.text?.toString()
        set(value) {
            binding?.tvTitle?.text = value
        }

    val prefixIcon: ImageView?
        get() = binding?.ivBack

    private var iconSrc: Int? = null
        set(value) {
            value?.let { binding?.ivBack?.setImageResource(it) }
            field = value
        }

    init {
        context.obtainStyledAttributes(attrs, R.styleable.HeaderView, 0, 0).run {
            try {
                title = getString(R.styleable.HeaderView_android_title)
                iconSrc = getInteger(R.styleable.HeaderView_icon_src, R.drawable.ic_baseline_chevron_left_24)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                recycle()
            }
        }
    }

    override fun initListener() {
        binding?.ivBack?.onClick {
            binding?.root?.navController?.popBackStack()
        }
    }

    override fun initView() {
    }
}
