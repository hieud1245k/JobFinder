package com.hieuminh.jobfinder.views.fragments.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.hieuminh.jobfinder.interfaces.InitLayout
import com.hieuminh.jobfinder.interfaces.BaseViewEvent
import com.hieuminh.jobfinder.presenters.UserContracts
import com.hieuminh.jobfinder.presenters.base.BasePresenter
import com.hieuminh.jobfinder.presenters.base.BaseView
import com.hieuminh.jobfinder.views.activity.base.BaseActivity

abstract class BaseAdvanceFragment<Na, Pre : BasePresenter, VBinding : ViewBinding> :
    BaseFragment<VBinding>() {
    protected var mPresenter: Pre? = null
    protected var mNavigator: Na? = null

    abstract fun getPresenter(): Pre

    abstract fun getNavigator(): Na

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initAdvanceData()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initAdvanceData() {
        mPresenter = getPresenter()
        mNavigator = getNavigator()
    }
}
