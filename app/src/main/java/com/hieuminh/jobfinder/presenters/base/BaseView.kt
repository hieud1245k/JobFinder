package com.hieuminh.jobfinder.presenters.base

import com.hieuminh.jobfinder.interfaces.BaseViewEvent

interface BaseView : BaseViewEvent {
    fun onFailure(errorMessage: String, code: Int? = null)
}
