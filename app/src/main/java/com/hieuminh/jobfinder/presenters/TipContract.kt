package com.hieuminh.jobfinder.presenters

import com.hieuminh.jobfinder.models.Tip
import com.hieuminh.jobfinder.presenters.base.BasePresenter
import com.hieuminh.jobfinder.presenters.base.BaseView

interface TipContract {
    interface Presenter : BasePresenter {
        fun getTipList()
    }

    interface View : BaseView {
        fun onSuccess(tipList: ArrayList<Tip>)
    }
}
