package com.hieuminh.jobfinder.presenters.impl

import com.hieuminh.jobfinder.models.response.LoginRes
import com.hieuminh.jobfinder.presenters.LoginContract
import com.hieuminh.jobfinder.presenters.base.BasePresenterImpl
import com.hieuminh.jobfinder.services.UserService
import com.hieuminh.jobfinder.utils.JsonUtils

class LoginContractImpl(private val view: LoginContract.View) : BasePresenterImpl(view), LoginContract.Presenter {
    private val service = apiClient.getService<UserService>()

    override fun login(username: String, password: String) {
        val params = mapOf("username" to username, "password" to password)
        enqueue(service.signIn(params)) { jsonObject ->
            JsonUtils.fromJson<LoginRes>(jsonObject)?.let { loginRes -> view.onLoginSuccess(loginRes) }
        }
    }
}
