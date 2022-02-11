package com.bimromatic.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project


/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2022/1/17
 * desc   :
 * version: 1.0
 * Link    :
 */
class UploadApkPlugin: Plugin<Project>{
    override fun apply(target: Project) {
    }
}

class ExtConfig {
   var message:String? = ""
}