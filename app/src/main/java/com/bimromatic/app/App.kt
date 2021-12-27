package com.bimromatic.app

import android.app.Application
import android.content.Context
import com.bimromatic.base.app.ApplicationLifecycle
import com.bimromatic.base.app.InitDepend
import com.google.auto.service.AutoService
import org.greenrobot.eventbus.EventBus


/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/1
 * desc   : this is system is main,you are read
 * version: 1.0
 */

@AutoService(ApplicationLifecycle::class)
class App : ApplicationLifecycle {

    override fun onAttachBaseContext(context: Context) {
        // 开启EventBusAPT,优化反射效率 当组件作为App运行时需要将添加的Index注释掉 因为找不到对应的类了
        EventBus
            .builder()
//            .addIndex(MainEventIndex())
            .installDefaultEventBus()
    }

    override fun onCreate(application: Application) {
    }

    override fun onTerminate(application: Application) {
    }

    override fun initByFrontDesk(): InitDepend = InitDepend(mutableListOf(),mutableListOf())


    override fun initByBackstage() {
    }


}