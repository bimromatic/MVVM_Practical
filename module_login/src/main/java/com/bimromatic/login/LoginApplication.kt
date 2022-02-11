package com.bimromatic.login

import android.app.Application
import android.content.Context
import android.util.Log
import com.bimromatic.base.app.ApplicationLifecycle
import com.bimromatic.base.app.InitDepend
import com.google.auto.service.AutoService

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/7
 * desc   :
 * version: 1.0
 * Link    :
 */

@AutoService(ApplicationLifecycle::class)
class LoginApplication: ApplicationLifecycle {
    override fun onAttachBaseContext(context: Context) {
    }

    override fun onCreate(application: Application) {
    }

    override fun onTerminate(application: Application) {
    }

    override fun initByFrontDesk(): MutableList<() -> String> = mutableListOf()


    //override fun initByFrontDesk(): InitDepend = InitDepend(mutableListOf(), mutableListOf())

    override fun initByBackstage() {
        Log.e("","")
    }


}