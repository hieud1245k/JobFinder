package com.hieuminh.jobfinder.views.customs

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.ImageView
import androidx.core.view.isVisible
import com.hieuminh.jobfinder.R
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.gone
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.visible
import com.hieuminh.jobfinder.databinding.ItemInputDataBinding
import com.hieuminh.jobfinder.views.customs.base.BaseInputDataView

open class EditView(context: Context?, attrs: AttributeSet?) :
    BaseInputDataView<ItemInputDataBinding>(context, attrs) {
    override val sourceView: EditText?
        get() = binding?.etInputData

    val prefixIcon: ImageView?
        get() = binding?.ivPrefixIcon

    val suffixIcon: ImageView?
        get() = binding?.ivSuffixIcon

    protected var suffixIconSrc: Int = 0

    override var title: CharSequence?
        get() = binding?.tvTitle?.text
        set(value) {
            binding?.tvTitle?.text = value
        }

    override var text: CharSequence?
        get() = binding?.etInputData?.text
        set(value) {
            binding?.etInputData?.setText(value)
        }

    override var hint: String?
        get() = binding?.etInputData?.hint?.toString()
        set(value) {
            binding?.etInputData?.hint = value
        }

    init {
        context?.obtainStyledAttributes(attrs, R.styleable.EditView, 0, 0)?.apply {
            try {
                suffixIconSrc = getResourceId(R.styleable.EditView_suffixIconSrc, 0)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                recycle()
            }
        }
    }

    override fun getViewBinding() =
        ItemInputDataBinding.inflate(LayoutInflater.from(context), this, true)

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

    override fun initView() {
        super.initView()
        if (suffixIconSrc != 0) {
            binding?.ivSuffixIcon?.run {
                visible()
                setImageResource(suffixIconSrc)
            }
        }
        if (binding?.tvTitle?.text.isNullOrEmpty()) {
            binding?.tvTitle?.gone()
        }
    }

    fun showError(message: String?) {
        binding?.layoutError?.root?.isVisible = message != null
        binding?.layoutError?.tvError?.text = message
    }
}
