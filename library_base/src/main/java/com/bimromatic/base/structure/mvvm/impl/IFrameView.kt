package com.bimromatic.base.structure.mvvm.impl

import androidx.viewbinding.ViewBinding

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/7
 * desc   : View层基类抽象
 * version: 1.0
 */
interface IFrameView<VB:ViewBinding> {
    /**
     * 初始化View
     */
    fun VB.initView()

    /**
     * 初始化LiveData的订阅关系
     */
    fun initLiveDataObserve()

    /**
     * 初始化界面创建时的数据请求
     */
    fun initRequestData()
}