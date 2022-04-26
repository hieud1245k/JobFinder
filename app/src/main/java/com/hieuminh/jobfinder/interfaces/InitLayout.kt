package com.hieuminh.jobfinder.interfaces

interface InitLayout<V> {
    fun getViewBinding(): V
    fun initListener()
    fun initView()
}
