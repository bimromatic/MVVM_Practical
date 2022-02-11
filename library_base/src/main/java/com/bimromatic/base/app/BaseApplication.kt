package com.bimromatic.base.app
import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.util.Log
import androidx.multidex.MultiDexApplication
import com.alibaba.android.arouter.launcher.ARouter
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/10
 * desc   :
 * version: 1.0
 * Link    :
 */

open class BaseApplication: MultiDexApplication() {

    private val TAG = "BaseApplication"

    private val mCoroutineScope by lazy(mode = LazyThreadSafetyMode.NONE) { MainScope() }
    private val mLoadModuleProxy by lazy(mode = LazyThreadSafetyMode.NONE) { LoadModuleProxy() }

    companion object {
        // 全局Context
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        @SuppressLint("StaticFieldLeak")
        lateinit var application: BaseApplication
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        context = base
        application = this
        mLoadModuleProxy.onAttachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        // 全局监听 Activity 生命周期
        registerActivityLifecycleCallbacks(ActivityLifecycleCallbacksImpl())
        mLoadModuleProxy.onCreate(this)
        // 策略初始化第三方依赖
        initDepends()
    }

    /**
     * 初始化第三方依赖
     */
    private fun initDepends() {
        // 开启一个 Default Coroutine 进行初始化不会立即使用的第三方
        mCoroutineScope.launch(Dispatchers.Default) {
            mLoadModuleProxy.initByBackstage()
        }

        // 初始化需要被立即初始化的第三方 多线程并行，并阻塞至全部完成
        val measureTimeMillis = measureTimeMillis {
            val depends = mLoadModuleProxy.initByFrontDesk()
            var dependInfo: String
            depends.forEach {
                val dependTimeMillis = measureTimeMillis { dependInfo = it() }
                Log.d(TAG, "initDepends: $dependInfo : $dependTimeMillis ms")
            }
//            mCoroutineScope.launch(Dispatchers.Main.immediate) {
//                val depends = mLoadModuleProxy.initByFrontDesk()
//
//                // 1. 对非必须在主线程初始化的第三方依赖发起并行初始化
//                // 并行job
//                var jobs: MutableList<Deferred<String>>? = null
//                if (depends.workerThreadDepends.isNotEmpty()) {
//                    jobs = mutableListOf()
//                    depends.workerThreadDepends.forEach {
//                        jobs.add(async(Dispatchers.Default) { it() })
//                    }
//                }
//
//                // 2. 对必须在主线程初始化的第三方依赖进行初始化
//                if (depends.mainThreadDepends.isNotEmpty()) {
//                    depends.mainThreadDepends.forEach { it() }
//                }
//
//                // 3. 等待每一个子线程初始化的依赖完成
//                jobs?.forEach { it.await() }
//            }
        }
        Log.d(TAG, "初始化完成 $measureTimeMillis ms")
    }

    override fun onTerminate() {
        super.onTerminate()
        mLoadModuleProxy.onTerminate(this)
        mCoroutineScope.cancel()
    }
}