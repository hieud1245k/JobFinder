package com.hieuminh.jobfinder.presenters.impl

import com.hieuminh.jobfinder.APIs.AppApiClient
import com.hieuminh.jobfinder.common.enums.UserRole
import com.hieuminh.jobfinder.models.response.LoginRes
import com.hieuminh.jobfinder.presenters.UserContracts
import com.hieuminh.jobfinder.presenters.base.BasePresenterImpl
import com.hieuminh.jobfinder.services.UserService
import com.hieuminh.jobfinder.utils.JsonUtils

object UserPresenterImpl {
    private val service = AppApiClient.getService<UserService>()

    class LoginPresenterImpl(private val view: UserContracts.LoginContract.View) :
        BasePresenterImpl(view), UserContracts.LoginContract.Presenter {

        override fun login(email: String, password: String) {
            val params = mapOf(
                "email" to email,
                "password" to password,
                "appUserRole" to UserRole.APPLICANT.index,
            )
            enqueue(service.signIn(params)) { jsonObject ->
                JsonUtils.fromJson<LoginRes>(jsonObject)
                    ?.let { loginRes -> view.onLoginSuccess(loginRes) }
            }
        }
    }

    class RegisterPresenterImpl(private var view: UserContracts.RegisterContract.View?) :
        BasePresenterImpl(view),
        UserContracts.RegisterContract.Presenter {

        override fun register(email: String, password: String) {
            val params = hashMapOf(
                "email" to email,
                "password" to password,
                "appUserRole" to UserRole.APPLICANT.index,
            )
            enqueue(service.signUp(params)) {
                view?.onRegisterSuccess()
            }
        }
    }

    class ActiveUserPresenterImpl(private var view: UserContracts.ActiveUserContract.View?) :
        BasePresenterImpl(view), UserContracts.ActiveUserContract.Presenter {
        override fun sendActiveCode(email: String, activeCode: Int) {
            val params = hashMapOf(
                "email" to email,
                "activeCode" to activeCode,
            )
            enqueue(service.activeAccount(params)) { loginRes ->
                view?.activeUserSuccess(loginRes)
            }
        }
    }

    class ResetPasswordPresenterImpl(private val view: UserContracts.ResetPasswordContract.View?) :
        BasePresenterImpl(view), UserContracts.ResetPasswordContract.Presenter {
        override fun verifyEmail(email: String) {
            val params = hashMapOf(
                "email" to email,
            )
            enqueue(service.verifyEmail(params)) { jsonObject ->
                if (jsonObject?.has("userId") == true) {
                    view?.verifyEmailSuccess(jsonObject["userId"].asInt)
                }
            }
        }

        override fun resetPassword(userId: Int, newPassword: String) {
        }
    }
}