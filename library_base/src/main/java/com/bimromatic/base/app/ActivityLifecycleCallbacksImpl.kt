package com.bimromatic.base.app

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import com.bimromatic.base.untils.manager.ActivityStackManager

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/22
 * desc   : Activity生命周期监听
 * version: 1.0
 * Link    :
 */
class ActivityLifecycleCallbacksImpl: Application.ActivityLifecycleCallbacks{

    private val TAG = "ActivityLifecycle"


    override fun onActivityCreated(p0: Activity, p1: Bundle?) {
        ActivityStackManager.addActivityToStack(p0)
        Log.e(TAG, "${p0.javaClass.simpleName} --> onActivityCreated")
    }

    override fun onActivityStarted(p0: Activity) {
        Log.e(TAG, "${p0.javaClass.simpleName} --> onActivityStarted")
    }

    override fun onActivityResumed(p0: Activity) {
        Log.e(TAG, "${p0.javaClass.simpleName} --> onActivityResumed")
    }

    override fun onActivityPaused(p0: Activity) {
        Log.e(TAG, "${p0.javaClass.simpleName} --> onActivityPaused")
    }

    override fun onActivityStopped(p0: Activity) {
        Log.e(TAG, "${p0.javaClass.simpleName} --> onActivityStopped")
    }

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
        Log.e(TAG, "${p0.javaClass.simpleName} --> onActivitySaveInstanceState")
    }

    override fun onActivityDestroyed(p0: Activity) {
        Log.e(TAG, "${p0.javaClass.simpleName} --> onActivityDestroyed")
    }

}