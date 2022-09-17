package com.hieuminh.jobfinder.presenters.impl

import com.hieuminh.jobfinder.APIs.AppApiClient
import com.hieuminh.jobfinder.presenters.TipContract
import com.hieuminh.jobfinder.presenters.base.BasePresenterImpl
import com.hieuminh.jobfinder.services.TipService

class TipPresenterImpl(private var view: TipContract.View?) : BasePresenterImpl(view), TipContract.Presenter {
    private val service = AppApiClient.getService<TipService>()

    override fun getTipList() {
        enqueue(service.getTipList()) { tipList ->
            view?.onSuccess(tipList ?: arrayListOf())
        }
    }
}
