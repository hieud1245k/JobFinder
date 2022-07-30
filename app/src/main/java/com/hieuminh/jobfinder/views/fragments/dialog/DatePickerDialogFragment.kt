package com.hieuminh.jobfinder.views.fragments.dialog

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*


class DatePickerDialogFragment: DialogFragment() {
    private var dataSetListener: OnDateSetListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]
        return DatePickerDialog(activity!!, dataSetListener, year, month, dayOfMonth)
    }

    fun setDataSetListener(dataSetListener: OnDateSetListener?) {
        this.dataSetListener = dataSetListener
    }
}