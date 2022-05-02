package com.hieuminh.jobfinder.views.activity.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.hieuminh.jobfinder.interfaces.InitLayout

abstract class BaseActivity<VBinding: ViewBinding>: AppCompatActivity(), InitLayout<VBinding> {
    var binding: VBinding? = null
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding?.root)
        initView()
        initListener()
    }
}
