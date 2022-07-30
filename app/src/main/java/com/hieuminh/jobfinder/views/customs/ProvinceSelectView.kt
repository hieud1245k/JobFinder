package com.hieuminh.jobfinder.views.customs

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import com.hieuminh.jobfinder.databinding.ItemProvinceSelectBinding
import com.hieuminh.jobfinder.views.customs.base.BaseInputDataView

class ProvinceSelectView(context: Context?, attrs: AttributeSet?) : BaseInputDataView<ItemProvinceSelectBinding>(context, attrs) {
    private var provinces = listOf("Quang Nam", "Da Nang", "Ha Noi", "Ho Chi Minh", "Quang Ngai", "Binh Dinh")

    override val sourceView: View?
        get() = null
    override var title: CharSequence?
        get() = binding?.tvTitle?.text
        set(value) {
            binding?.tvTitle?.text = value
        }
    override var text: CharSequence?
        get() = null
        set(value) {}

    override fun getViewBinding() = ItemProvinceSelectBinding.inflate(LayoutInflater.from(context), this, true)

    override fun initListener() {

    }

    override fun initView() {
        super.initView()
        val adapter = ArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, provinces)
        binding?.spProvinceSelect?.adapter = adapter
    }

    fun showError(message: String?) {
        binding?.layoutError?.root?.isVisible = message != null
        binding?.layoutError?.tvError?.text = message
    }
}