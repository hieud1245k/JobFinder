package com.hieuminh.jobfinder.views.customs

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.widget.EditText
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.hideKeyboard
import com.hieuminh.jobfinder.databinding.LayoutInputCodeBinding
import com.hieuminh.jobfinder.views.customs.base.BaseLinearLayout

class InputCodeLayout(context: Context?, attrs: AttributeSet?) :
    BaseLinearLayout<LayoutInputCodeBinding>(context, attrs) {
    private var inputCodeListener: InputCodeListener? = null

    private val listView: List<EditText?>
        get() = listOf(
            binding?.etFirstCode,
            binding?.etSecondCode,
            binding?.etThirdCode,
            binding?.etFourthCode
        )

    private val codeClickListener = OnClickListener {
        listView.firstOrNull()?.requestFocus()
    }

    private fun addTextChangedListener(editText: EditText?) {
        editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) =
                Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit

            override fun afterTextChanged(value: Editable?) {
                if (value.isNullOrEmpty()) {
                    return
                }
                try {
                    val index = listView.indexOf(editText)
                    if (listView.lastIndex == index) {
                        editText.clearFocus()
                        editText.hideKeyboard()
                        val code = listView.fold("") { code, view ->
                            code.plus(view?.text.toString().trim())
                        }
                        inputCodeListener?.inputCodeCompleted(code)
                    } else {
                        listView[index.inc()]?.run {
                            setText("")
                            requestFocus()
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        })
    }

    override fun getViewBinding() =
        LayoutInputCodeBinding.inflate(LayoutInflater.from(context), this, true)

    override fun initListener() {
        addTextChangedListener(binding?.etFirstCode)
        addTextChangedListener(binding?.etSecondCode)
        addTextChangedListener(binding?.etThirdCode)
        addTextChangedListener(binding?.etFourthCode)
        binding?.llContainer?.setOnClickListener(codeClickListener)
    }

    override fun initView() = Unit

    fun setInputCodeListener(listener: InputCodeListener) {
        this.inputCodeListener = listener
    }

    interface InputCodeListener {
        fun inputCodeCompleted(code: String)
    }
}
