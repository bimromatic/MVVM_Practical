package com.bimromatic.plugin.uploadapk

import groovy.lang.Closure
import org.gradle.api.Action
import org.gradle.util.ConfigureUtil
import java.io.File

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2022/1/17
 * desc   :
 * version: 1.0
 * Link    :
 */
class PgyerOption {
    var apiKey: String = ""
    var apks = ArrayList<ApkOption>()

    //创建内部Extension，名称为方法名 apk
    fun apk(action: Action<ApkOption>) {
        val apk = ApkOption("", "", "", File("./"))
        action.execute(apk)
        apks.add(apk)
    }

    //创建内部Extension，名称为方法名 apk
    fun apk(c: Closure<ApkOption>) {
        val apk = ApkOption("", "", "", File("./"))
        ConfigureUtil.configure(c, apk)
        apks.add(apk)
    }

    override fun toString() = "apiKey:$apiKey\n apks:$apks \n"
}

open class ApkOption(var name: String, var build: String, var desc: String, var apk: File) {

    override fun toString() = "\n(name:$name,build:$build,desc:$desc,apk:${apk.name})"
}