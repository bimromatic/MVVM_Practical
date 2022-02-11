package com.bimromatic.app

import android.app.Application
import android.content.Context
import com.bimromatic.base.app.ApplicationLifecycle
import com.bimromatic.base.app.BaseApplication
import com.bimromatic.base.app.InitDepend
import com.google.auto.service.AutoService
import dagger.hilt.android.HiltAndroidApp
import org.greenrobot.eventbus.EventBus


/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/1
 * desc   : this is system is main,you are read
 * version: 1.0
 */

@HiltAndroidApp//会触发 Hilt 的代码生成操作，生成的代码包括应用的一个基类，该基类充当应用级依赖项容器
class App : BaseApplication() {
    override fun onCreate() {
        // 开启EventBusAPT,优化反射效率 当组件作为App运行时需要将添加的Index注释掉 因为找不到对应的类了
        EventBus
            .builder()
            //.addIndex(MainEventIndex())
            .installDefaultEventBus()
        super.onCreate()
    }
}