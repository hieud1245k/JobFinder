package com.hieuminh.jobfinder.common.extensions

import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity

object ViewExtensions {
    fun View.hideKeyboard() {
        try {
            val inputMethodManager = context.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
