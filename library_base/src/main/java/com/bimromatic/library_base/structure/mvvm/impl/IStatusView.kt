package com.bimromatic.library_base.structure.mvvm.impl

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/7
 * desc   :
 * version: 1.0
 */
interface IStatusView {
    fun showEmptyView() //空视图
    fun showErrorView(errMsg: String) //错误视图
    fun showLoadingView(isShow: Boolean) //展示Loading视图
}