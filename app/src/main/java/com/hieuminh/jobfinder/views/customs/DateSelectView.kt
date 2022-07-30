package com.hieuminh.jobfinder.views.customs

import android.content.Context
import android.util.AttributeSet
import androidx.fragment.app.FragmentActivity
import com.hieuminh.jobfinder.R
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.onClick
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.toTextView
import com.hieuminh.jobfinder.views.fragments.dialog.DatePickerDialogFragment

class DateSelectView(context: Context?, attrs: AttributeSet?) : EditView(context, attrs) {
    init {
        suffixIconSrc = R.drawable.ic_calendar_day
    }

    private fun showDateSelectDialog() {
        val activity = context as? FragmentActivity ?: return
        val datePicker = DatePickerDialogFragment()
        datePicker.setDataSetListener { _, year, month, day ->
            val fullDay = if(day < 10) "0".plus(day) else day
            val fullMonth = if(month < 10) "0".plus(month) else month
            binding?.etInputData?.setText("$fullDay/$fullMonth/$year")
        }
        datePicker.show(activity.supportFragmentManager, "")
    }

    override fun initListener() {
        super.initListener()
        binding?.llInputData?.onClick { showDateSelectDialog() }
    }

    override fun initView() {
        super.initView()
        binding?.etInputData?.toTextView()
    }
}