package com.hieuminh.jobfinder.views.customs

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.view.View.OnClickListener
import com.hieuminh.jobfinder.R
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.visible

class PasswordView(context: Context?, attrs: AttributeSet?) : EditView(context, attrs) {

    private val togglePasswordStateListener = OnClickListener {
        if (sourceView?.inputType == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
            sourceView?.inputType =
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            suffixIcon?.setImageResource(R.drawable.ic_eye_hidden)
        } else {
            sourceView?.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            suffixIcon?.setImageResource(R.drawable.ic_eye_open)
        }
    }

    override fun initListener() {
        super.initListener()
        suffixIcon?.setOnClickListener(togglePasswordStateListener)
    }

    override fun initView() {
        super.initView()
        suffixIcon?.visible()
        suffixIcon?.setImageResource(R.drawable.ic_eye_hidden)
        sourceView?.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
    }
}