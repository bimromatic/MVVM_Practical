package com.bimromatic.library_base.app
import android.annotation.SuppressLint
import android.content.Context
import androidx.multidex.MultiDexApplication

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/10
 * desc   :
 * version: 1.0
 * Link    :
 */
class BaseApplication: MultiDexApplication() {

    companion object {
        // 全局Context
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        @SuppressLint("StaticFieldLeak")
        lateinit var application: BaseApplication
    }

}