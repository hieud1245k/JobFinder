package com.hieuminh.jobfinder.common.extensions

import android.content.res.Resources

object NumberExtensions {
    val Float.dp: Int
        get() = (this * Resources.getSystem().displayMetrics.density).toInt()

    val Int.dp: Int
        get() = this.toFloat().dp
}
