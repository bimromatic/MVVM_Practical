package com.bimromatic.common

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.bimromatic.base.app.ApplicationLifecycle
import com.bimromatic.base.app.BaseApplication
import com.bimromatic.base.app.InitDepend
import com.bimromatic.base.untils.ProcessUtils
import com.bimromatic.common.util.cvs.VersionStatus
import com.google.auto.service.AutoService

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/10
 * desc   :
 * version: 1.0
 * Link    :
 */
@AutoService(ApplicationLifecycle::class)
class CommonApplication : ApplicationLifecycle {

    /**
     * 项目当前的版本状态
     */
    val versionStatus: String by lazy { BaseApplication.context.getString(R.string.VERSION_STATUS) }

    companion object {
        // 全局CommonApplication
        @SuppressLint("StaticFieldLeak")
        lateinit var mCommonApplication: CommonApplication
    }

    /**
     * 同[Application.attachBaseContext]
     * @param context Context
     */
    override fun onAttachBaseContext(context: Context) {
        mCommonApplication = this
    }

    /**
     * 同[Application.onCreate]
     * @param application Application
     */
    override fun onCreate(application: Application) {}

    /**
     * 同[Application.onTerminate]
     * @param application Application
     */
    override fun onTerminate(application: Application) {}

    override fun initByFrontDesk(): InitDepend {
        val worker = mutableListOf<() -> String>()
        val main = mutableListOf<() -> String>()
        // 以下只需要在主进程当中初始化 按需要调整
        if (ProcessUtils.isMainProcess(BaseApplication.context)) {
            //worker.add { initMMKV() }
            worker.add { initARouter() }
        }
        //worker.add { initTencentBugly() }
        return InitDepend(main, worker)
    }

    override fun initByBackstage() {
    }


//
//    /**
//     * 腾讯TBS WebView X5 内核初始化
//     */
//    private fun initX5WebViewCore() {
//        // dex2oat优化方案
//        val map = HashMap<String, Any>()
//        map[TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER] = true
//        map[TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE] = true
//        QbSdk.initTbsSettings(map)
//
//        // 允许使用非wifi网络进行下载
//        QbSdk.setDownloadWithoutWifi(true)
//
//        // 初始化
//        QbSdk.initX5Environment(BaseApplication.context, object : PreInitCallback {
//
//            override fun onCoreInitFinished() {
//                Log.d("ApplicationInit", " TBS X5 init finished")
//            }
//
//            override fun onViewInitFinished(p0: Boolean) {
//                // 初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核
//                Log.d("ApplicationInit", " TBS X5 init is $p0")
//            }
//        })
//    }
//
//    /**
//     * 腾讯 MMKV 初始化
//     */
//    private fun initMMKV(): String {
//        val result = SpUtils.initMMKV(BaseApplication.context)
//        return "MMKV -->> $result"
//    }
//
    /**
     * 阿里路由 ARouter 初始化
     */
    private fun initARouter(): String {
        // 测试环境下打开ARouter的日志和调试模式 正式环境需要关闭
        if (versionStatus == VersionStatus.ALPHA || versionStatus == VersionStatus.BETA) {
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(BaseApplication.application)
        return "ARouter -->> init complete"
    }
//
//    /**
//     * 初始化 腾讯Bugly
//     * 测试环境应该与正式环境的日志收集渠道分隔开
//     * 目前有两个渠道 测试版本/正式版本
//     */
//    private fun initTencentBugly(): String {
//        // 第三个参数为SDK调试模式开关
//        CrashReport.initCrashReport(
//            BaseApplication.context,
//            BaseApplication.context.getString(R.string.BUGLY_APP_ID),
//            versionStatus == VersionStatus.ALPHA || versionStatus == VersionStatus.BETA
//        )
//        return "Bugly -->> init complete"
//    }
}