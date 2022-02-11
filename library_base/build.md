apply plugin: 'com.android.library'
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-kapt'
apply plugin: 'dagger.hilt.android.plugin'
/*序列化插件*/
apply plugin: 'kotlin-parcelize'



android {
    compileSdkVersion BuildConfig.compileSdkVersion
    buildToolsVersion BuildConfig.buildToolsVersion
    defaultConfig {
        minSdkVersion BuildConfig.minSdk
        targetSdkVersion BuildConfig.targetSdk
        versionCode BuildConfig.versionCode
        versionName BuildConfig.versionName
        consumerProguardFiles BuildConfig.androidJUnitRunner

        ndk {
            // 设置支持的SO库架构
            //abiFilters 'armeabi', 'x86', 'armeabi-v7a', 'x86_64', 'arm64-v8a'
            abiFilters 'armeabi-v7a', 'arm64-v8a', 'x86'
        }
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        viewBinding = true
    }

    resourcePrefix "base_"


    //避免编译不能用于在编译类路径中发现的注解处理器，因为它们中的任何更改都需要运行注解处理任务
    kapt.includeCompileClasspath = false


    //针对库依赖项提高了 lint 性能：https://developer.android.com/studio/releases/gradle-plugin?hl=zh-cn
//    lint {
//        isCheckDependencies = true
//    }
}

kapt {
    arguments {
        arg("AROUTER_MODULE_NAME", project.name)
        arg("eventBusIndex", "eventbus.index.${project.name}EventIndex")
    }
}

dependencies {
    implementation fileTree(include : [ "*.jar", '*.aar'], dir : "libs")

    /**AndroidX*/
    api AndroidX.CoreKtx
    api AndroidX.AppCompat
    api AndroidX.MultiDex
    api AndroidX.ConstraintLayout


    //compileOnly DepsAndroidX.ViewBinding

    /**UIMaterial*/
    api UIMaterial.Material

    /**Kotlin*/
    api Kotlin.Kotlin
    api Kotlin.CoroutinesCore
    api Kotlin.CoroutinesAndroid

    /**JetPack*/
    api JetPack.LifecycleViewModel
    api JetPack.LifecycleLiveData
    api JetPack.LifecycleRuntime
    //api DepsJetPack.LifecycleExtensions
    api JetPack.LifecycleRuntimeKtx
    api JetPack.LifecycleViewModelKtx
    api JetPack.LifecycleViewModelSavedState
    //api JetPack.LifecycleApt
    api JetPack.HiltCore
    api JetPack.Room
    api JetPack.RoomKtx
    api JetPack.WorkRuntimeKtx

    /**GitHub*/
    api GitHub.EventBus
    api GitHub.AutoService
    api GitHub.Rxjava
    api GitHub.OkHttp
    api GitHub.OkHttpInterceptorLogging
    api GitHub.Retrofit
    api GitHub.RetrofitConverterGson
    api GitHub.MMKV
    api GitHub.AutoSize
    api GitHub.Gson
    api GitHub.Glide
    api GitHub.ARoute
    api GitHub.RecyclerViewAdapter
    api GitHub.Appctx
    api GitHub.Systemservices
    api GitHub.Views

    /**kapt*/
    kapt GitHub.GlideCompiler
    kapt GitHub.ARouteCompiler
    kapt GitHub.EventBusAPT
    kapt GitHub.ARouteCompiler
    kapt GitHub.AutoServiceAnnotations
    kapt JetPack.HiltApt
    kapt JetPack.HiltAndroidx
    kapt JetPack.LifecycleApt
    kapt JetPack.RoomCompiler

    /**test*/
//    testImplementation Test.Junit
//    androidTestImplementation Test.androidTestJunit
//    androidTestImplementation Test.espressoCore
//    kaptAndroidTest Test.TestHilt
}

kapt {
    arguments {
        arg("AROUTER_MODULE_NAME", project.getName())
    }
}
