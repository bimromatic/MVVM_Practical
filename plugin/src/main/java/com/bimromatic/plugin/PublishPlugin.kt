package com.bimromatic.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File
import java.util.*
import kotlin.io.*
import com.android.build.gradle.BaseExtension
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin
import org.gradle.api.tasks.bundling.Jar
import org.gradle.api.tasks.javadoc.Javadoc
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.create
import org.gradle.plugins.signing.SigningPlugin

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


        System.out.println("========================")
        System.out.println("apply MyPlugin succeed!")
        System.out.println("========================")

        println("======> 可参考 https://www.codenong.com/cs106835734/  《===========")




//        val isAndroid = project.hasProperty("android")
//        if (isAndroid){
//            project.tasks.register("")
//        }

//        if (isAndroid) {
//
//
//            project.allprojects {
//
//            }
//            println("android")
//            val android = project.extensions.getByName("android") as BaseExtension
//
//            //register sourcesJar for android
//            project.tasks.register('sourcesJar',Jar::class.java){
//            }
//
//            // for Android
////            val register = project.tasks.register('sourcesJar', Jar) {
////
////                archiveClassifier.set('sources')
////                from plugins . hasPlugin ('kotlin-android') ?
////            }
//
////            val sourcesJar = project.tasks.register("sourcesJar", Jar::class.java){
////                archiveClassifier.set("sources")
////                from(android.sourceSets.getByName("main").java.srcDirs)
////            }
//
//            //register task javadoc for android
////            val javadoc = project.tasks.register("javadoc", Javadoc::class.java) {
////                isFailOnError = false
////                setSource(android.sourceSets.getByName("main").java.srcDirs)
////                classpath += project.files(android.bootClasspath.joinToString(File.pathSeparator))
////            }
////            project.tasks.register("androidJavaDocsJar", Jar::class.java) {
////                archiveClassifier.set("javadoc")
////                dependsOn(javadoc)
////                from(javadoc.get().destinationDir)
////            }
//        }else{
//            println("java/kotlin")
//            project.configure<JavaPluginExtension> {
//                withSourcesJar()
//                withJavadocJar()
//            }
//        }
//
//        project.afterEvaluate {
//            val properties = Properties()
//            val file = project.rootProject.file("gradle/deploy.properties")
//            if (file.exists()) {
//                properties.load(file.inputStream())
//                val mavenUrl = properties.getProperty("maven.url")
//                val mavenUsername = properties.getProperty("maven.username")
//                val mavenPassword = properties.getProperty("maven.password")
//                println("mavenUrl:$mavenUrl")
//
//                project.configure<PublishingExtension> {
//                    repositories {
//                        maven {
//                            setUrl(mavenUrl)
//                            credentials {
//                                username = mavenUsername
//                                password = mavenPassword
//                            }
//                        }
//                    }
//                    publications {
//                        create<MavenPublication>("release") {
//                            if(isAndroid){
//                                artifact(project.tasks.getByName("sourcesJar"))
//                                artifact(project.tasks.getByName("androidJavaDocsJar"))
//                                from(components.getByName("release"))
//                            }else{
//                                from(components.getByName("java"))
//                            }
//
//                            groupId = project.group as String
//                            artifactId = project.name
//                            version = project.version as String
//
//                            pom {
//                                name.set("${project.group}:${project.name}")
//                                url.set("https://github.com/Tencent/QMUI_Android")
//                                licenses {
//                                    license {
//                                        name.set(properties.getProperty("license.name"))
//                                        url.set(properties.getProperty("license.url"))
//                                    }
//                                }
//                                developers {
//                                    developer {
//                                        id.set(properties.getProperty("developer.id"))
//                                        name.set(properties.getProperty("developer.name"))
//                                        email.set(properties.getProperty("developer.email"))
//                                    }
//                                }
//                                scm {
//                                    connection.set("scm:git:git://github.com/Tencent/QMUI_Android.git")
//                                    developerConnection.set("scm:git:ssh://github.com/Tencent/QMUI_Android.git")
//                                    url.set("https://qmuiteam.com/android")
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }
}