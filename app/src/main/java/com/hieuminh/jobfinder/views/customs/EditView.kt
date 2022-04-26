package com.hieuminh.jobfinder.views.customs

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import com.hieuminh.jobfinder.databinding.ItemInputDataBinding
import com.hieuminh.jobfinder.views.customs.base.BaseInputDataView

class EditView(context: Context?, attrs: AttributeSet?) : BaseInputDataView<ItemInputDataBinding>(context, attrs) {
    override var title: String?
        get() = binding?.tvTitle?.text?.toString()
        set(value) {
            binding?.tvTitle?.text = value
        }

    override var text: String?
        get() = binding?.etInputData?.text?.toString()
        set(value) {
            binding?.etInputData?.setText(value)
        }

    override fun getViewBinding() = ItemInputDataBinding.inflate(LayoutInflater.from(context), this, true)

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit

        override fun afterTextChanged(value: Editable?) {
            textChangedListener?.onTextChanged(value?.toString())
        }
    }

    override fun initListener() {
        binding?.etInputData?.addTextChangedListener(textWatcher)
    }
}
