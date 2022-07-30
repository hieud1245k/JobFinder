package com.hieuminh.jobfinder.utils

import android.content.Context
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

object ImageUtils {
    fun createImageFile(context: Context?): File {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        return File(
            "${context?.packageResourcePath}/cameraImages", "IMG_" + timeStamp +
                    ".jpg"
        )
    }
}