package com.hieuminh.jobfinder.views.customs

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.core.view.isVisible
import com.hieuminh.jobfinder.R
import com.hieuminh.jobfinder.databinding.ItemSettingViewBinding
import com.hieuminh.jobfinder.views.customs.base.BaseLinearLayout

class SettingItemView(context: Context?, attrs: AttributeSet?) : BaseLinearLayout<ItemSettingViewBinding>(context, attrs) {

    init {
        context?.obtainStyledAttributes(attrs, R.styleable.SettingItemView, 0, 0)?.run {
            try {
                binding?.tvName?.text = getString(R.styleable.SettingItemView_android_text)
                binding?.ivPrefixIcon?.setImageResource(getResourceId(R.styleable.SettingItemView_prefixIconSrc, 0))
                binding?.ivPrefixIcon?.backgroundTintList = ColorStateList.valueOf(
                    getColor(R.styleable.SettingItemView_prefixBackgroundTint, 0)
                ).takeIf { it.defaultColor != 0 }
                binding?.bottomViewLine?.isVisible = getBoolean(R.styleable.SettingItemView_hasBottomViewLine, true)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                recycle()
            }
        }
    }

    override fun getViewBinding() = ItemSettingViewBinding.inflate(LayoutInflater.from(context), this, true)

    override fun initListener() {
    }
}
