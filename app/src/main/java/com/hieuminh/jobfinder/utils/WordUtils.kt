package com.hieuminh.jobfinder.utils

import android.os.Build
import android.text.Html
import android.text.Spanned
import com.hieuminh.jobfinder.common.constants.AppConstants

object WordUtils {
    fun decodeBOM(url: String): String {
        return url.replace("\uFEFF", "")
    }

    fun fromHtml(html: String): Spanned {
        val url = decodeBOM(html)
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(url, Html.FROM_HTML_MODE_LEGACY)
        } else Html.fromHtml(url)
    }

    fun getResendCodeText() {

    }
    fun getRequireText(text: String): CharSequence {
        val requireLabel = text.plus("<font color=red> ${AppConstants.REQUIRED_LABEL}</font>")
        return WordUtils.fromHtml(requireLabel)
    }

}
