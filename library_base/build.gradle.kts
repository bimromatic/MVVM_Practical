import com.bimromatic.plugin.Dep
import java.io.ByteArrayOutputStream
import java.util.*
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

plugins{
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("com.github.ben-manes.versions")
}


fun runCommand(project: Project, command: String): String {
    val stdout = ByteArrayOutputStream()
    project.exec {
        commandLine = command.split(" ")
        standardOutput = stdout
    }
    return stdout.toString().trim()
}


val gitVersion = runCommand(project, "git rev-list HEAD --count").toIntOrNull() ?: 1

android {

    compileSdk = Dep.ProjectBuildConfig.compileSdkVersion
    compileOptions {
        sourceCompatibility = Dep.javaVersion
        targetCompatibility = Dep.javaVersion
    }

    defaultConfig {
        minSdk = Dep.ProjectBuildConfig.minSdk
        targetSdk = Dep.ProjectBuildConfig.targetSdk

        //这里有一个坑 就是无法设置 versionCode 和 versionName 目前猜测是只有主工程才能设置
        //versionCode = gitVersion
        //versionName = Dep.ProjectBuildConfig.versionName
    }

//    buildTypes {
//        release {
//            isMinifyEnabled=false
//            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
//        }
//    }

    buildFeatures {
        //compose = true
        dataBinding = true
        viewBinding = true
    }

//    composeOptions {
//        kotlinCompilerExtensionVersion = "1.1.0-rc01"
//    }
//
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }


    compileOptions {
        sourceCompatibility = Dep.javaVersion
        targetCompatibility = Dep.javaVersion
    }
    kotlinOptions {
        jvmTarget = Dep.kotlinJvmTarget
    }

    kapt.includeCompileClasspath = true
}



fun String.isNonStable(): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(this)
    return isStable.not()
}

tasks.withType<DependencyUpdatesTask> {

    // Example 1: reject all non stable versions
    rejectVersionIf {
        candidate.version.isNonStable()
    }

    // Example 2: disallow release candidates as upgradable versions from stable versions
    rejectVersionIf {
        candidate.version.isNonStable() && !currentVersion.isNonStable()
    }

    // Example 3: using the full syntax
    resolutionStrategy {
        componentSelection {
            all {
                if (candidate.version.isNonStable() && !currentVersion.isNonStable()) {
                    reject("Release candidate")
                }
            }
        }
    }

    // optional parameters
    checkForGradleUpdate = true
    outputFormatter = "json"
    outputDir = "build/dependencyUpdates"
    reportfileName = "report"
}





dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))

    /**AndroidX*/
    api(Dep.AndroidX.CoreKtx)
    api(Dep.AndroidX.AppCompat)
    api(Dep.AndroidX.MultiDex)
    api(Dep.AndroidX.ConstraintLayout)


    //compileOnly DepsAndroidX.ViewBinding

    /**UIMaterial*/
    api(Dep.UIMaterial.Material)

    /**Kotlin*/
    api(Dep.Kotlin.Kotlin)
    api(Dep.Kotlin.CoroutinesCore)
    api(Dep.Kotlin.CoroutinesAndroid)

    /**JetPack*/
    api(Dep.JetPack.LifecycleViewModel)
    api(Dep.JetPack.LifecycleLiveData)
    api(Dep.JetPack.LifecycleRuntime)
    //api DepsJetPack.LifecycleExtensions
    api(Dep.JetPack.LifecycleRuntimeKtx)
    api(Dep.JetPack.LifecycleViewModelKtx)
    api(Dep.JetPack.LifecycleViewModelSavedState)
    //api Dep.JetPack.LifecycleApt
    api(Dep.JetPack.HiltCore)
    api(Dep.JetPack.Room)
    api(Dep.JetPack.RoomKtx)
    api(Dep.JetPack.WorkRuntimeKtx)

    /**GitHub*/
    api(Dep.GitHub.EventBus)
    api(Dep.GitHub.AutoService)
    api(Dep.GitHub.Rxjava)
    api(Dep.GitHub.OkHttp)
    api(Dep.GitHub.OkHttpInterceptorLogging)
    api(Dep.GitHub.Retrofit)
    api(Dep.GitHub.RetrofitConverterGson)
    api(Dep.GitHub.MMKV)
    api(Dep.GitHub.AutoSize)
    api(Dep.GitHub.Gson)
    api(Dep.GitHub.Glide)
    api(Dep.GitHub.ARoute)
    api(Dep.GitHub.RecyclerViewAdapter)
    api(Dep.GitHub.Appctx)
    api(Dep.GitHub.Systemservices)
    api(Dep.GitHub.Views)

    /**kapt*/
    kapt(Dep.GitHub.GlideCompiler)
    kapt(Dep.GitHub.ARouteCompiler)
    kapt(Dep.GitHub.EventBusAPT)
    kapt(Dep.GitHub.ARouteCompiler)
    kapt(Dep.GitHub.AutoServiceAnnotations)
    kapt(Dep.JetPack.HiltApt)
    kapt(Dep.JetPack.HiltAndroidx)
    kapt(Dep.JetPack.LifecycleApt)
    kapt(Dep.JetPack.RoomCompiler)

    /**test*/
//    testImplementation Test.Junit
//    androidTestImplementation Test.androidTestJunit
//    androidTestImplementation Test.espressoCore
//    kaptAndroidTest Test.TestHilt
}

kapt {
    //useBuildCache = true
    correctErrorTypes = true
    includeCompileClasspath = true
    arguments {
        arg("AROUTER_MODULE_NAME", project.name)
        arg("eventBusIndex", "eventbus.index.${project.name}EventIndex")
    }

    javacOptions {
        // 增加注解处理器的最大错误次数
        // 默认为 100。
        option("-Xmaxerrs", 500)
    }
}

extra["PUBLISH_ARTIFACT_ID"] = "lib-base"


apply {
    from("../publish-mavencentral.gradle")
}



//extra["PUBLISH_VERSION"] = "0.0.1"
//extra["ISLOCAL"] = false
//
//apply {
//    from("../publish-mavencentral.gradle")
//}

