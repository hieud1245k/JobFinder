package com.hieuminh.jobfinder.views.customs

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import com.hieuminh.jobfinder.databinding.ItemProvinceSelectBinding
import com.hieuminh.jobfinder.views.customs.base.BaseInputDataView

class ProvinceSelectView(context: Context?, attrs: AttributeSet?) : BaseInputDataView<ItemProvinceSelectBinding>(context, attrs) {
    private var provinces = listOf("Quang Nam", "Da Nang", "Ha Noi", "Ho Chi Minh", "Quang Ngai", "Binh Dinh")

    override val sourceView: View?
        get() = null
    override var title: String?
        get() = null
        set(value) {}
    override var text: String?
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
}