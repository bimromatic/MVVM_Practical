package com.bimromatic

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import kotlinx.coroutines.MainScope

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/7
 * desc   :
 * version: 1.0
 * Link    :
 */
class App: Application() {

    private val mCoroutineScope by lazy(mode = LazyThreadSafetyMode.NONE) { MainScope() }

    private val mLoadModuleProxy by lazy(mode = LazyThreadSafetyMode.NONE) {
        //LoadModuleProxy()
    }

    companion object {
        // 全局Context
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        @SuppressLint("StaticFieldLeak")
        lateinit var application: Application
    }
}