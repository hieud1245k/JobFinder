package com.hieuminh.jobfinder.views.fragments.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.hieuminh.jobfinder.interfaces.InitLayout
import com.hieuminh.jobfinder.interfaces.BaseViewEvent
import com.hieuminh.jobfinder.views.activity.base.BaseActivity

abstract class BaseFragment<VBinding : ViewBinding> : Fragment(), InitLayout<VBinding>, BaseViewEvent {
    var binding: VBinding? = null
        private set

    private val baseActivity: BaseActivity<*>?
        get() = activity as? BaseActivity<*>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initListener()
    }

    override fun onConnectInternetFailure() {
        baseActivity?.onConnectInternetFailure()
    }

    override fun startLoading() {
        baseActivity?.startLoading()
    }

    override fun endLoading() {
        baseActivity?.endLoading()
    }
}
