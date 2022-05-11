package com.hieuminh.jobfinder.presenters

import com.hieuminh.jobfinder.models.response.LoginRes
import com.hieuminh.jobfinder.presenters.base.BasePresenter
import com.hieuminh.jobfinder.presenters.base.BaseView

interface LoginContract {
    interface Presenter : BasePresenter {
        fun login(username: String, password: String)
    }

    interface View : BaseView {
        fun onLoginSuccess(loginRes: LoginRes)
    }
}
