package com.hieuminh.jobfinder.presenters

import com.google.gson.JsonObject
import com.hieuminh.jobfinder.models.ApplicantProfile
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
        interface Presenter : BasePresenter {
            fun sendActiveCode(email: String, activeCode: Int)
        }

        interface View : BaseView {
            fun activeUserSuccess(loginRes: LoginRes?)
        }
    }

    interface ResetPasswordContract {
        interface Presenter : BasePresenter {
            fun verifyEmail(email : String)
            fun resetPassword(userId: Int, newPassword: String)
        }

        interface View : BaseView {
            fun resetPasswordSuccessful(loginRes: LoginRes)
            fun verifyEmailSuccess(userId: Int)
        }
    }

    interface ProfileContract {
        interface Presenter: BasePresenter {
            fun createProfile(applicantProfile: ApplicantProfile)
        }

        interface  View: BaseView {
            fun createProfileSuccess(jsonObject: JsonObject?)
        }
    }
}