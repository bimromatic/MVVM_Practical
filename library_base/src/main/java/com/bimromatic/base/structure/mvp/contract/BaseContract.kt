package com.bimromatic.base.structure.mvp.contract

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/7
 * desc   :
 * version: 1.0
 */
interface BaseContract {

    interface BasePresenter {
        fun attachView(view: BaseView)
        fun detachView()
        fun cancelAll()
    }

    interface BaseView {
        /**
         * @param flag 用于标记对应接口
         * @param e 错误信息
         */
        fun showError( e: Throwable?)
    }
}