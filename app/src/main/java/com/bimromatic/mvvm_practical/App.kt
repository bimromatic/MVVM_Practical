package com.bimromatic.mvvm_practical

import android.app.Application

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/1
 * desc   : this is system is main,you are read
 * version: 1.0
 */

class App :Application(){

    override fun onCreate() {
        super.onCreate()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}