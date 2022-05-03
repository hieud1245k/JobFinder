package com.hieuminh.jobfinder.views.customs.base

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.viewbinding.ViewBinding
import com.hieuminh.jobfinder.R

@SuppressLint("Recycle")
abstract class BaseInputDataView<VBinding : ViewBinding>(context: Context?, attrs: AttributeSet?) : BaseLinearLayout<VBinding>(context, attrs) {
    protected var textChangedListener: OnTextChangedListener? = null

    abstract var title: String?
    abstract var text: String?
    open var hint: String? = null

    init {
        context?.obtainStyledAttributes(attrs, R.styleable.BaseInputDataView, 0, 0)?.run {
            try {
                title = getString(R.styleable.BaseInputDataView_view_title)
                text = getString(R.styleable.BaseInputDataView_text)
                hint = getString(R.styleable.BaseInputDataView_hint)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                recycle()
            }
        }
    }

    fun addTextChangedListener(listener: OnTextChangedListener) {
        this.textChangedListener = listener
    }

    interface OnTextChangedListener {
        fun onTextChanged(text: String?)
    }
}
