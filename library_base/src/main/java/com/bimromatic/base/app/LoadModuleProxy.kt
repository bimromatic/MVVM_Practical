package com.bimromatic.base.app

import android.app.Application
import android.content.Context
import android.util.Log
import java.util.*

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/10
 * desc   :
 * version: 1.0
 * Link    :
 */
class LoadModuleProxy: ApplicationLifecycle {

    private var mLoader: ServiceLoader<ApplicationLifecycle> =
        ServiceLoader.load(ApplicationLifecycle::class.java)

    /**
     * 同[Application.attachBaseContext]
     * @param context Context
     */
    override fun onAttachBaseContext(context: Context) {
        mLoader.forEach {
            Log.d("ApplicationInit", it.toString())
            it.onAttachBaseContext(context)
        }
    }

    /**
     * 同[Application.onCreate]
     * @param application Application
     */
    override fun onCreate(application: Application) {
        mLoader.forEach { it.onCreate(application) }
    }

    /**
     * 同[Application.onTerminate]
     * @param application Application
     */
    override fun onTerminate(application: Application) {
        mLoader.forEach { it.onTerminate(application) }
    }

    /**
     * 需要立即进行初始化的放在这里进行并行初始化
     * @return MutableList<() -> String> 初始化方法的集合
     */
    override fun initByFrontDesk(): InitDepend {
        val mainThreadDepends: MutableList<() -> String> = mutableListOf()
        val workerThreadDepends: MutableList<() -> String> = mutableListOf()
        mLoader.forEach {
            mainThreadDepends.addAll(it.initByFrontDesk().mainThreadDepends)
            workerThreadDepends.addAll(it.initByFrontDesk().workerThreadDepends)
        }
        return InitDepend(mainThreadDepends, workerThreadDepends)
    }

    /**
     * 不需要立即初始化的放在这里进行后台初始化
     */
    override fun initByBackstage() {
        mLoader.forEach { it.initByBackstage() }
    }
}