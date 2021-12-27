/**
 * desc   : 项目相关参数配置
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/11/30
 */


interface BuildConfig {
    int compileSdkVersion = 31
    String buildToolsVersion = "29.0.3"
    int minSdk = 21
    int targetSdk = 31
    int versionCode = 1
    String versionName = "1.0.0"
    def androidJUnitRunner = "androidx.test.runner.AndroidJUnitRunner"
    def isAppMode = false

    def versionStatus = /*"VERSION_STATUS_RELEASE"*/ "VERSION_STATUS_ALPHA" /*"VERSION_STATUS_BETA"*/
}


/**
 * desc   : 依赖版本号
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/11/30
 */

interface Version{
    // AndroidX--------------------------------------------------------------
    String AppCompat = "1.4.0"
    String CoreKtx = "1.3.2"
    String ConstraintLayout = "2.0.4"                // 约束布局
    String TestExtJunit = "1.1.2"
    String TestEspresso = "3.3.0"
    String ActivityKtx = "1.1.0"
    String FragmentKtx = "1.2.5"
    String MultiDex = "2.0.1"

    // Android---------------------------------------------------------------
    //String Junit = "4.13"
    String Material = "1.3.0"                        // 材料设计UI套件

    //test
    String junitExt = "1.1.2"
    String espressoCore = "3.4.0"
    String timber = "4.7.1"
    String Junit = "4.13"


    // Kotlin----------------------------------------------------------------
    String Kotlin = "1.4.32"
    String Coroutines = "1.4.3"                      // 协程

    // JetPack---------------------------------------------------------------
    String LifecycleViewModel = "2.2.0"
    String LifecycleRuntimeKtx = "2.2.0"
    String LifecycleViewModelKtx = "2.2.0"
    String Lifecycle = "2.3.1"                       // Lifecycle相关（ViewModel & LiveData & Lifecycle）
    String Room = "2.3.0"                            // 官方推荐数据库框架
    String Hilt = "2.35.1"                           // DI框架-Hilt
    String HiltAndroidx = "1.0.0"
    String WorkVersion = "2.7.1"


    // GitHub----------------------------------------------------------------
    String OkHttp = "3.14.9"                         // OkHttp
    String OkHttpInterceptorLogging = "3.12.0"       // OkHttp 请求Log拦截器
    String Retrofit = "2.9.0"                        // Retrofit
    String RetrofitConverterGson = "2.9.0"           // Retrofit Gson 转换器
    String Gson = "2.8.6"                            // Gson
    String MMKV = "1.2.2"                            // 腾讯 MMKV 替代SP
    String AutoSize = "1.2.1"                        // 屏幕适配
    String Glide = "4.11.0"                          // Glide
    String ARoute = "1.5.1"                          // 阿里路由
    String ARouteCompiler = "1.5.1"                  // 阿里路由 APT
    String RecyclerViewAdapter = "3.0.4"             // RecyclerViewAdapter
    String StatusBar = "1.5.1"                       // 状态栏
    String EventBus = "3.2.0"                        // 事件总线
    String PermissionX = "1.3.0"                     // 权限申请
    String LeakCanary = "2.4"                        // 检测内存泄漏
    String AutoService = "1.0"                       // 自动生成SPI暴露服务文件


    String Splitties = "2.1.1"

    // 第三方SDK--------------------------------------------------------------
    String TencentBugly = "3.3.7"                 // 腾讯Bugly 异常上报
    String TencentBuglyNative = "3.8.0"                     // Bugly native异常上报
    String TencentTBSX5 = "43939"                      // 腾讯X5WebView

    // RxJava--------------------------------------------------------------
    String Rxjava = "3.0.0"

    String AutoDispose = "2.1.1"

    // viewbinding--------------------------------------------------------------
    String Viewbinding = "7.0.1"

}






/**
 * desc   : AndroidX相关依赖
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/11/30
 */

interface AndroidX {
    String AppCompat = "androidx.appcompat:appcompat:${Version.AppCompat}"
    String CoreKtx = "androidx.core:core-ktx:${Version.CoreKtx}"
    String ConstraintLayout = "androidx.constraintlayout:constraintlayout:${Version.ConstraintLayout}"
    String TestExtJunit = "androidx.test.ext:junit:${Version.TestExtJunit}"
    String TestEspresso = "androidx.test.espresso:espresso-core:${Version.TestEspresso}"
    String ActivityKtx = "androidx.activity:activity-ktx:${Version.ActivityKtx}"
    String FragmentKtx = "androidx.fragment:fragment-ktx:${Version.FragmentKtx}"
    String MultiDex = "androidx.multidex:multidex:${Version.MultiDex}"
    String ViewBinding  = "androidx.databinding:viewbinding:${Version.Viewbinding}"
}


/**
 * desc   : Android相关依赖
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/11/30
 */

interface Android {

}


interface UIMaterial{
    String Material = "com.google.android.material:material:${Version.Material}"
}

/**
 * desc   : JetPack相关依赖
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/11/30
 */

interface JetPack {
    String LifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel:${Version.LifecycleViewModel}"
    String LifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.LifecycleRuntimeKtx}"
    String LifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.LifecycleViewModelKtx}"
    String LifecycleViewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Version.Lifecycle}"
    String LifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.Lifecycle}"
    String LifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.Lifecycle}"
    String LifecycleApt = "androidx.lifecycle:lifecycle-compiler:${Version.Lifecycle}"
    String LifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Version.Lifecycle}"

    String Room = "androidx.room:room-runtime:${Version.Room}"
    String RoomCompiler = "androidx.room:room-compiler:${Version.Room}"
    String RoomKtx = "androidx.room:room-ktx:${Version.Room}"


    String HiltCore = "com.google.dagger:hilt-android:${Version.Hilt}"
    String HiltApt = "com.google.dagger:hilt-compiler:${Version.Hilt}"
    String HiltAndroidx = "androidx.hilt:hilt-compiler:${Version.HiltAndroidx}"


    String WorkRuntimeKtx = "androidx.work:work-runtime-ktx:${Version.WorkVersion}"
}

/**
 * desc   : Kotlin相关依赖
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/11/30
 */

interface Kotlin {
    String Kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Version.Kotlin}"
    String CoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.Coroutines}"
    String CoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.Coroutines}"
}

/**
 * desc   : GitHub及其他相关依赖
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/11/30
 */

interface GitHub {
    String OkHttp = "com.squareup.okhttp3:okhttp:${Version.OkHttp}"
    String OkHttpInterceptorLogging = "com.squareup.okhttp3:logging-interceptor:${Version.OkHttpInterceptorLogging}"
    String Retrofit = "com.squareup.retrofit2:retrofit:${Version.Retrofit}"
    String RetrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Version.RetrofitConverterGson}"
    String Gson = "com.google.code.gson:gson:${Version.Gson}"
    String MMKV = "com.tencent:mmkv-static:${Version.MMKV}"
    String AutoSize = "me.jessyan:autosize:${Version.AutoSize}"
    String Glide = "com.github.bumptech.glide:glide:${Version.Glide}"
    String GlideCompiler = "com.github.bumptech.glide:compiler:${Version.Glide}"
    String ARoute = "com.alibaba:arouter-api:${Version.ARoute}"
    String ARouteCompiler = "com.alibaba:arouter-compiler:${Version.ARouteCompiler}"
    String RecyclerViewAdapter = "com.github.CymChad:BaseRecyclerViewAdapterHelper:${Version.RecyclerViewAdapter}"
    String StatusBar = "com.jaeger.statusbarutil:library:${Version.StatusBar}"
    String EventBus = "org.greenrobot:eventbus:${Version.EventBus}"
    String EventBusAPT = "org.greenrobot:eventbus-annotation-processor:${Version.EventBus}"
    String PermissionX = "com.permissionx.guolindev:permissionx:${Version.PermissionX}"
    String LeakCanary = "com.squareup.leakcanary:leakcanary-android:${Version.LeakCanary}"
    String AutoService = "com.google.auto.service:auto-service:${Version.AutoService}"
    String AutoServiceAnnotations = "com.google.auto.service:auto-service-annotations:${Version.AutoService}"

    String Rxjava = "io.reactivex.rxjava3:rxjava:${Version.Rxjava}"
    String Rxandroid = "io.reactivex.rxjava3:rxandroid:${Version.Rxjava}"
    //:自动解绑<MVP 模式下面 view 与 Presenter 自动解绑解决内存泄漏的风险> ==》https://github.com/uber/AutoDispose
    String Autodispose = "com.uber.autodispose2:autodispose-android:${Version.AutoDispose}"


    String Appctx = "com.louiscad.splitties:splitties-appctx:${Version.Splitties}"
    String Systemservices = "com.louiscad.splitties:splitties-systemservices:${Version.Splitties}"
    String Views = "com.louiscad.splitties:splitties-views:${Version.Splitties}"
}



/**
 * desc   : SDK相关依赖
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/11/30
 */
interface SDK {
    String TencentBugly = "com.tencent.bugly:crashreport:${Version.TencentBugly}"
    String TencentBuglyNative = "com.tencent.bugly:nativecrashreport:${Version.TencentBuglyNative}"
    String TencentTBSX5 = "com.tencent.tbs.tbssdk:sdk:${Version.TencentTBSX5}"
}


/**
 * desc   : test相关依赖
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/11/30
 */


interface DepsTest{
    String TestHilt = "com.google.dagger:hilt-android-compiler:${Version.Hilt}"
    String Junit = "junit:junit:${Version.Junit}"
    String androidTestJunit = "androidx.test.ext:junit:${Version.junitExt}"
    String espressoCore = "androidx.test.espresso:espresso-core:${Version.espressoCore}"
    String timber = "com.jakewharton.timber:timber:${Version.timber}"
}

interface Dependencies {
//    String app_compat = "com.android.support:appcompat-v7:${Versions.support}"
//    String kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
//    String kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
//    String gradle_plugin = "com.android.tools.build:gradle:${Versions.gradle}"

//    String addRepos: (handler: RepositoryHandler) -> Unit = {
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



