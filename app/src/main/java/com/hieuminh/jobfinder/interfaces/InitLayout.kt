package com.hieuminh.jobfinder.interfaces

interface InitLayout<VBinding> {
    fun getViewBinding(): VBinding
    fun initListener()
    fun initView()
}
