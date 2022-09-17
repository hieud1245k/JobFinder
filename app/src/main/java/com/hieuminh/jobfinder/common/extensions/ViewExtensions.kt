package com.hieuminh.jobfinder.common.extensions

import android.text.InputType
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation

object ViewExtensions {
    fun View.hideKeyboard() {
        try {
            val inputMethodManager =
                context.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun View.visible() {
        visibility = View.VISIBLE
    }

    fun View.gone() {
        visibility = View.GONE
    }

    fun View.invisible() {
        visibility = View.INVISIBLE
    }

    fun View.onClick(onClick: () -> Unit) {
        this.setOnClickListener {
            onClick.invoke()
        }
    }

    fun EditText.toTextView() {
        inputType = InputType.TYPE_NULL
        isCursorVisible = false
        isFocusable = false
    }

    val View.navController: NavController?
        get() = try {
            Navigation.findNavController(this)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
}
