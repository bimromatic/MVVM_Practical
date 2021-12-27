package com.bimromatic.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/27
 * desc   :
 * version: 1.0
 * Link    :
 */
class PublishPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        val isAndroid = project.hasProperty("android")

    }
}