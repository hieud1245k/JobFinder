package com.hieuminh.jobfinder.common.extensions

object StringExtensions {
    fun String.toSafeInt(): Int {
        return try {
            Integer.parseInt(this)
        } catch (e: Exception) {
            -1
        }
    }
}