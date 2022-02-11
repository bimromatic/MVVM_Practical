plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    `kotlin-dsl`
}





//android {
//    compileSdkVersion(29)
//    defaultConfig {
//        applicationId = "com.xxx.xxxxx"
//        minSdkVersion(21)
//        targetSdkVersion(29)
//        versionCode = 27
//        versionName = "2.2.0"
//        resConfigs("zh")
//        externalNativeBuild {
//            cmake {
//                //根据需要 自行选择添加的对应cpu类型的.so库。 这里暂时没实现
//                abiFilters("armeabi")
//            }
//        }
//    }
//
//    //开启dataBinding
//    buildFeatures {
//        dataBinding = true
//    }
//
//    //图片已压缩 指定aapt不做图片压缩 因为可能会反而增加图片大小
//    aaptOptions {
////        cruncherEnabled = false
//    }
//
//    //关闭lint检查
//    lintOptions {
//        disable("ResourceType")
////        abortOnError  = false
//    }
//
//    //jniLibs目录指向libs目录
//    sourceSets {
//        getByName("main") {
//            jniLibs.srcDirs("libs")
//        }
//    }
//
//    //优化transformClassDexBuilderForDebug的时间
//    dexOptions {
//        preDexLibraries = true
//        maxProcessCount = 8
//    }
//
//    //禁止生成依赖元数据 不上play用不到
//    dependenciesInfo {
//        includeInApk = false
//    }
//
//    //jdk1.8支持
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//
//    kotlinOptions {
//        jvmTarget = JavaVersion.VERSION_1_8.toString()
//    }
//
//    //签名配置
//    signingConfigs {
//        getByName("debug") {
//            storeFile = file("../xxx.jks")
//            storePassword = "xxx"
//            keyAlias = "xxx"
//            keyPassword = "xxx"
//        }
//    }
//
//    buildTypes {
//        getByName("debug") {
//            //签名
//            signingConfig = signingConfigs.getByName("debug")
//            //git提交次数 作为测试包版本后缀
//            buildConfigField("int", "GIT_COMMIT_COUNT", getGitCommitCount())
//        }
//        register("alpha") {
//            //继承debug配置
//            initWith(getByName("debug"))
//            //混淆
//            isMinifyEnabled = true
//            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
//            //ZipAlignEnabled优化
//            isZipAlignEnabled = true
//            //移除无用的resource文件
//            isShrinkResources = true
//        }
//        getByName("release") {
//            //继承alpha配置
//            initWith(getByName("alpha"))
//            //关闭debug
//            debuggable(false)
//        }
//    }
//
//    //release打包时自定义apk名字、输出路径
//    android.applicationVariants.all {
//        outputs.all {
//            if (this is com.android.build.gradle.internal.api.ApkVariantOutputImpl) {
//                this.outputFileName = "xxxx.apk"
//            }
//        }
//    }
//}
//
////获取git提交次数
//fun getGitCommitCount(): String {
//    val os = org.apache.commons.io.output.ByteArrayOutputStream()
//    project.exec {
//        commandLine = "git rev-list --count HEAD".split(" ")
//        standardOutput = os
//    }
//    return String(os.toByteArray()).trim()
//}
//
////依赖库
//apply(from = "depends.gradle")
//
////task
//apply(from = "tasks.gradle")
//
////aop
////apply(from = "aopconfig.gradle")