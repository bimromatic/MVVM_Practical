package com.bimromatic.library_base.app

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

    override fun onAttachBaseContext(context: Context) {
        mLoader.forEach {
            Log.d("ApplicationInit", it.toString())
            it.onAttachBaseContext(context)
        }
    }

    override fun onCreate(application: Application) {
        mLoader.forEach { it.onCreate(application) }
    }

    override fun onTerminate(application: Application) {
        mLoader.forEach { it.onTerminate(application) }
    }

    override fun initByFrontDesk(): InitDepend {
        val mainThreadDepends: MutableList<() -> String> = mutableListOf()
        val workerThreadDepends: MutableList<() -> String> = mutableListOf()
        mLoader.forEach {
            mainThreadDepends.addAll(it.initByFrontDesk().mainThreadDepends)
            workerThreadDepends.addAll(it.initByFrontDesk().workerThreadDepends)
        }
        return InitDepend(mainThreadDepends, workerThreadDepends)
    }

    override fun initByBackstage() {
        mLoader.forEach { it.initByBackstage() }
    }
}