package com.hieuminh.jobfinder.presenters

import com.hieuminh.jobfinder.models.response.LoginRes
import com.hieuminh.jobfinder.presenters.base.BasePresenter
import com.hieuminh.jobfinder.presenters.base.BaseView

interface UserContracts {
    interface LoginContract {
        interface Presenter : BasePresenter {
            fun login(email: String, password: String)
        }

        interface View : BaseView {
            fun onLoginSuccess(loginRes: LoginRes)
        }
    }

    interface RegisterContract {
        interface Presenter : BasePresenter {
            fun register(email: String, password: String)
        }

        interface View : BaseView {
            fun onRegisterSuccess()
        }
    }

    interface ActiveUserContract {
        interface Presenter: BasePresenter {
            fun sendActiveCode(email: String, activeCode: Int)
        }

        interface View: BaseView {
            fun activeUserSuccess(loginRes: LoginRes?)
        }
    }
}