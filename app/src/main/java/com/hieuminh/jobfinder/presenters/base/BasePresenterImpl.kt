package com.hieuminh.jobfinder.presenters.base

import com.hieuminh.jobfinder.APIs.AppApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class BasePresenterImpl(private var view: BaseView?) : BasePresenter {
    val apiClient = AppApiClient


    fun <T> enqueue(call: Call<T>?, onSuccess: (T?) -> Unit) {
        view?.startLoading()
        val callBack = object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                view?.endLoading()
                if (response.isSuccessful) {
                    onSuccess(response.body())
                    return
                }
                val errorMessage = when(response.code()) {
                    401 -> "Your account do not permitted!"
                    else -> "User name or password incorrect!"
                }
                view?.onFailure(errorMessage, response.code())
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                view?.onConnectInternetFailure()
                view?.endLoading()
            }
        }
        call?.enqueue(callBack)
    }

    override fun onDestroy() {
        view = null
    }
}
