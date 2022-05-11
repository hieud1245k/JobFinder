package com.hieuminh.jobfinder.presenters.base

import com.hieuminh.jobfinder.APIs.AppApiClient
import kotlinx.coroutines.flow.combine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class BasePresenterImpl(private var view: BaseView?) : BasePresenter {
    val apiClient = AppApiClient


    fun <T> enqueue(call: Call<T>?, onSuccess: (T?) -> Unit) {
        view?.startLoading()
        val callBack = object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    onSuccess(response.body())
                } else {
                    view?.onFailure(response.message(), response.code())
                }
                view?.endLoading()
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
