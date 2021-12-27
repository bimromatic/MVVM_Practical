package com.bimromatic.plugin

import org.gradle.api.JavaVersion

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/27
 * desc   :
 * version: 1.0
 * Link    :
 */
object Dep {

    val javaVersion = JavaVersion.VERSION_11
    const val kotlinJvmTarget = "11"
    const val group = "com.bimromatic"


    object BuildConfig {
        const val compileSdkVersion = 31
        const val buildToolsVersion = "29.0.3"
        const val minSdk = 21
        const val targetSdk = 31
        const val versionCode = 1
        const val versionName = "1.0.0"
        const val androidJUnitRunner = "androidx.test.runner.AndroidJUnitRunner"
        const val isAppMode = false

        const val versionStatus = /*"VERSION_STATUS_RELEASE"*/ "VERSION_STATUS_ALPHA" /*"VERSION_STATUS_BETA"*/
    }

    object ProjectPlugin{
        const val AndroidGradleToolsPlugin = "com.android.tools.build:gradle:7.0.4"
        const val AndroidToolsPlugin = "com.android.tools.build:gradle:4.2.1"
        const val KotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0"
        const val ARouterRegister = "com.alibaba:arouter-register:1.0.2"
        const val HiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:2.38.1"
        const val DokkaGradle = "org.jetbrains.dokka:dokka-gradle-plugin:1.6.0"
    }


    /**
     * desc   : 依赖版本号
     * author : bimromatic
     * e-mail : xxx@xx
     * time   : 2021/11/30
     */

    object Version{
        // AndroidX--------------------------------------------------------------
        const val AppCompat = "1.4.0"
        const val CoreKtx = "1.3.2"
        const val ConstraintLayout = "2.0.4"                // 约束布局
        const val TestExtJunit = "1.1.2"
        const val TestEspresso = "3.3.0"
        const val ActivityKtx = "1.1.0"
        const val FragmentKtx = "1.2.5"
        const val MultiDex = "2.0.1"

        // Android---------------------------------------------------------------
        //const val Junit = "4.13"
        const val Material = "1.3.0"                        // 材料设计UI套件

        //test
        const val junitExt = "1.1.2"
        const val espressoCore = "3.4.0"
        const val timber = "4.7.1"
        const val Junit = "4.13"


        // Kotlin----------------------------------------------------------------
        const val Kotlin = "1.4.32"
        const val Coroutines = "1.4.3"                      // 协程

        // JetPack---------------------------------------------------------------
        const val LifecycleViewModel = "2.2.0"
        const val LifecycleRuntimeKtx = "2.2.0"
        const val LifecycleViewModelKtx = "2.2.0"
        const val Lifecycle = "2.3.1"                       // Lifecycle相关（ViewModel & LiveData & Lifecycle）
        const val Room = "2.3.0"                            // 官方推荐数据库框架
        const val Hilt = "2.35.1"                           // DI框架-Hilt
        const val HiltAndroidx = "1.0.0"
        const val WorkVersion = "2.7.1"


        // GitHub----------------------------------------------------------------
        const val OkHttp = "3.14.9"                         // OkHttp
        const val OkHttpInterceptorLogging = "3.12.0"       // OkHttp 请求Log拦截器
        const val Retrofit = "2.9.0"                        // Retrofit
        const val RetrofitConverterGson = "2.9.0"           // Retrofit Gson 转换器
        const val Gson = "2.8.6"                            // Gson
        const val MMKV = "1.2.2"                            // 腾讯 MMKV 替代SP
        const val AutoSize = "1.2.1"                        // 屏幕适配
        const val Glide = "4.11.0"                          // Glide
        const val ARoute = "1.5.1"                          // 阿里路由
        const val ARouteCompiler = "1.5.1"                  // 阿里路由 APT
        const val RecyclerViewAdapter = "3.0.4"             // RecyclerViewAdapter
        const val StatusBar = "1.5.1"                       // 状态栏
        const val EventBus = "3.2.0"                        // 事件总线
        const val PermissionX = "1.3.0"                     // 权限申请
        const val LeakCanary = "2.4"                        // 检测内存泄漏
        const val AutoService = "1.0"                       // 自动生成SPI暴露服务文件


        const val Splitties = "2.1.1"

        // 第三方SDK--------------------------------------------------------------
        const val TencentBugly = "3.3.7"                 // 腾讯Bugly 异常上报
        const val TencentBuglyNative = "3.8.0"                     // Bugly native异常上报
        const val TencentTBSX5 = "43939"                      // 腾讯X5WebView

        // RxJava--------------------------------------------------------------
        const val Rxjava = "3.0.0"

        const val AutoDispose = "2.1.1"

        // viewbinding--------------------------------------------------------------
        const val Viewbinding = "7.0.1"


        // Compose--------------------------------------------------------------
        val version = "1.1.0-rc01"
    }






    /**
     * desc   : AndroidX相关依赖
     * author : bimromatic
     * e-mail : xxx@xx
     * time   : 2021/11/30
     */

    object AndroidX {
        const val AppCompat = "androidx.appcompat:appcompat:${Version.AppCompat}"
        const val CoreKtx = "androidx.core:core-ktx:${Version.CoreKtx}"
        const val ConstraintLayout = "androidx.constraintlayout:constraintlayout:${Version.ConstraintLayout}"
        const val TestExtJunit = "androidx.test.ext:junit:${Version.TestExtJunit}"
        const val TestEspresso = "androidx.test.espresso:espresso-core:${Version.TestEspresso}"
        const val ActivityKtx = "androidx.activity:activity-ktx:${Version.ActivityKtx}"
        const val FragmentKtx = "androidx.fragment:fragment-ktx:${Version.FragmentKtx}"
        const val MultiDex = "androidx.multidex:multidex:${Version.MultiDex}"
        const val ViewBinding  = "androidx.databinding:viewbinding:${Version.Viewbinding}"
    }


    /**
     * desc   : Android相关依赖
     * author : bimromatic
     * e-mail : xxx@xx
     * time   : 2021/11/30
     */

    object Android {

    }


    object UIMaterial{
        const val Material = "com.google.android.material:material:${Version.Material}"
    }

    /**
     * desc   : JetPack相关依赖
     * author : bimromatic
     * e-mail : xxx@xx
     * time   : 2021/11/30
     */

    object JetPack {
        const val LifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel:${Version.LifecycleViewModel}"
        const val LifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.LifecycleRuntimeKtx}"
        const val LifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.LifecycleViewModelKtx}"
        const val LifecycleViewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Version.Lifecycle}"
        const val LifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.Lifecycle}"
        const val LifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.Lifecycle}"
        const val LifecycleApt = "androidx.lifecycle:lifecycle-compiler:${Version.Lifecycle}"
        const val LifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Version.Lifecycle}"

        const val Room = "androidx.room:room-runtime:${Version.Room}"
        const val RoomCompiler = "androidx.room:room-compiler:${Version.Room}"
        const val RoomKtx = "androidx.room:room-ktx:${Version.Room}"


        const val HiltCore = "com.google.dagger:hilt-android:${Version.Hilt}"
        const val HiltApt = "com.google.dagger:hilt-compiler:${Version.Hilt}"
        const val HiltAndroidx = "androidx.hilt:hilt-compiler:${Version.HiltAndroidx}"


        const val WorkRuntimeKtx = "androidx.work:work-runtime-ktx:${Version.WorkVersion}"
    }

    /**
     * desc   : Compose相关依赖
     * author : bimromatic
     * e-mail : xxx@xx
     * time   : 2021/11/30
     */
    object Compose {
        val animation = "androidx.compose.animation:animation:${Version.version}"
        val ui = "androidx.compose.ui:ui:${Version.version}"
        val material = "androidx.compose.material:material:${Version.version}"
        val compiler = "androidx.compose.compiler:compiler:${Version.version}"
    }

    /**
     * desc   : Kotlin相关依赖
     * author : bimromatic
     * e-mail : xxx@xx
     * time   : 2021/11/30
     */

    object Kotlin {
        const val Kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Version.Kotlin}"
        const val CoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.Coroutines}"
        const val CoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.Coroutines}"
    }

    /**
     * desc   : GitHub及其他相关依赖
     * author : bimromatic
     * e-mail : xxx@xx
     * time   : 2021/11/30
     */

    object GitHub {
        const val OkHttp = "com.squareup.okhttp3:okhttp:${Version.OkHttp}"
        const val OkHttpInterceptorLogging = "com.squareup.okhttp3:logging-interceptor:${Version.OkHttpInterceptorLogging}"
        const val Retrofit = "com.squareup.retrofit2:retrofit:${Version.Retrofit}"
        const val RetrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Version.RetrofitConverterGson}"
        const val Gson = "com.google.code.gson:gson:${Version.Gson}"
        const val MMKV = "com.tencent:mmkv-static:${Version.MMKV}"
        const val AutoSize = "me.jessyan:autosize:${Version.AutoSize}"
        const val Glide = "com.github.bumptech.glide:glide:${Version.Glide}"
        const val GlideCompiler = "com.github.bumptech.glide:compiler:${Version.Glide}"
        const val ARoute = "com.alibaba:arouter-api:${Version.ARoute}"
        const val ARouteCompiler = "com.alibaba:arouter-compiler:${Version.ARouteCompiler}"
        const val RecyclerViewAdapter = "com.github.CymChad:BaseRecyclerViewAdapterHelper:${Version.RecyclerViewAdapter}"
        const val StatusBar = "com.jaeger.statusbarutil:library:${Version.StatusBar}"
        const val EventBus = "org.greenrobot:eventbus:${Version.EventBus}"
        const val EventBusAPT = "org.greenrobot:eventbus-annotation-processor:${Version.EventBus}"
        const val PermissionX = "com.permissionx.guolindev:permissionx:${Version.PermissionX}"
        const val LeakCanary = "com.squareup.leakcanary:leakcanary-android:${Version.LeakCanary}"
        const val AutoService = "com.google.auto.service:auto-service:${Version.AutoService}"
        const val AutoServiceAnnotations = "com.google.auto.service:auto-service-annotations:${Version.AutoService}"

        const val Rxjava = "io.reactivex.rxjava3:rxjava:${Version.Rxjava}"
        const val Rxandroid = "io.reactivex.rxjava3:rxandroid:${Version.Rxjava}"
        //:自动解绑<MVP 模式下面 view 与 Presenter 自动解绑解决内存泄漏的风险> ==》https://github.com/uber/AutoDispose
        const val Autodispose = "com.uber.autodispose2:autodispose-android:${Version.AutoDispose}"


        const val Appctx = "com.louiscad.splitties:splitties-appctx:${Version.Splitties}"
        const val Systemservices = "com.louiscad.splitties:splitties-systemservices:${Version.Splitties}"
        const val Views = "com.louiscad.splitties:splitties-views:${Version.Splitties}"
    }



    /**
     * desc   : SDK相关依赖
     * author : bimromatic
     * e-mail : xxx@xx
     * time   : 2021/11/30
     */
    object SDK {
        const val TencentBugly = "com.tencent.bugly:crashreport:${Version.TencentBugly}"
        const val TencentBuglyNative = "com.tencent.bugly:nativecrashreport:${Version.TencentBuglyNative}"
        const val TencentTBSX5 = "com.tencent.tbs.tbssdk:sdk:${Version.TencentTBSX5}"
    }


    /**
     * desc   : test相关依赖
     * author : bimromatic
     * e-mail : xxx@xx
     * time   : 2021/11/30
     */


    object DepsTest{
        const val TestHilt = "com.google.dagger:hilt-android-compiler:${Version.Hilt}"
        const val Junit = "junit:junit:${Version.Junit}"
        const val androidTestJunit = "androidx.test.ext:junit:${Version.junitExt}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espressoCore}"
        const val timber = "com.jakewharton.timber:timber:${Version.timber}"
    }

    object Dependencies {
//    const val app_compat = "com.android.support:appcompat-v7:${Versions.support}"
//    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
//    const val kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
//    const val gradle_plugin = "com.android.tools.build:gradle:${Versions.gradle}"

//    const val addRepos: (handler: RepositoryHandler) -> Unit = {
//        it.google()
//        it.maven { it.url = URI("https://oss.sonatype.org/content/repositories/snapshots") }
//        it.maven { it.url = URI("https://jitpack.io") }
//        it.maven { it.url = URI("https://repo1.maven.org/maven2/") }
//        it.maven { it.url = URI("https://s01.oss.sonatype.org/content/groups/public") }
//        it.maven { it.url = URI("https://maven.aliyun.com/repository/central") }
//        it.maven { it.url = URI("https://maven.aliyun.com/repository/jcenter") }
//        it.maven { it.url = URI("https://maven.aliyun.com/repository/google") }
//        it.maven { it.url = URI("https://maven.aliyun.com/repository/gradle-plugin") }
//        it.maven { it.url = URI("https://maven.aliyun.com/repository/public") }
//    }
    }

}