package com.hieuminh.jobfinder.views.customs

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import com.hieuminh.jobfinder.databinding.ItemParagraphViewBinding
import com.hieuminh.jobfinder.views.customs.base.BaseInputDataView

class ParagraphView(context: Context?, attrs: AttributeSet?) :
    BaseInputDataView<ItemParagraphViewBinding>(context, attrs) {
    override fun getViewBinding() =
        ItemParagraphViewBinding.inflate(LayoutInflater.from(context), this, true)

    override fun initListener() {
    }

    override val sourceView: EditText?
        get() = binding?.etParagraphView

    override var title: CharSequence?
        get() = binding?.tvTitle?.text
        set(value) {
            binding?.tvTitle?.text = value
        }

    override var text: CharSequence?
        get() = binding?.etParagraphView?.text
        set(value) {
            binding?.etParagraphView?.setText(value)
        }

    override var hint: String?
        get() = binding?.etParagraphView?.hint?.toString()
        set(value) {
            binding?.etParagraphView?.hint = value
        }
}