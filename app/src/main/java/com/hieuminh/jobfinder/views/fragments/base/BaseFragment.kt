package com.hieuminh.jobfinder.views.fragments.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.hieuminh.jobfinder.interfaces.InitLayout

abstract class BaseFragment<VBinding : ViewBinding> : Fragment(), InitLayout<VBinding> {
    var binding: VBinding? = null
        private set

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = getViewBinding()
        initView()
        initListener()
    }
}
