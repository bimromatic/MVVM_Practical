package com.bimromatic.library_base.untils.network

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/10
 * desc   :
 * version: 1.0
 * Link    :
 */
class AutoRegisterNetListener constructor(listener: NetworkStateChangeListener) :
    LifecycleObserver {

    /**
     * 当前需要自动注册的监听器
     */
    private var mListener: NetworkStateChangeListener? = null

    init {
        mListener = listener
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun register() {
        mListener?.run { NetworkStateClient.setListener(this) }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun unregister() {
        NetworkStateClient.removeListener()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun clean() {
        NetworkStateClient.removeListener()
        mListener = null
    }
}