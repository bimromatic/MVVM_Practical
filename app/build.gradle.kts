import java.io.ByteArrayOutputStream
import com.bimromatic.plugin.Dep
import org.jetbrains.kotlin.config.JvmAnalysisFlags.useIR
import kotlin.reflect.full.memberFunctions

plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
    id(GradlePluginId.DokkaPlugin)
    kotlin(GradlePluginId.AndroidPlugin)
    kotlin(GradlePluginId.kaptPlugin)
    id(GradlePluginId.HiltPlugin)
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



//获取git提交次数
fun getGitCommitCount(): String {
    val os = org.apache.commons.io.output.ByteArrayOutputStream()
    project.exec {
        commandLine = "git rev-list --count HEAD".split(" ")
        standardOutput = os
    }
    return String(os.toByteArray()).trim()
}


android {

    compileSdk = Dep.ProjectBuildConfig.compileSdkVersion


    compileOptions {
        sourceCompatibility = Dep.javaVersion
        targetCompatibility = Dep.javaVersion
    }




    defaultConfig {
        applicationId = "com.bimromatic.mvvm_practical"
        minSdk = Dep.ProjectBuildConfig.minSdk
        targetSdk = Dep.ProjectBuildConfig.targetSdk
        versionCode = Dep.ProjectBuildConfig.versionCode
        versionName = Dep.ProjectBuildConfig.versionName
        //testInstrumentationRunner= BuildConfig.androidJUnitRunner
    }



//    buildTypes {
//        getByName("release") {
//            isMinifyEnabled = true
//            // TODO: b/120517460 shrinkResource can't be used with dynamic-feature at this moment.
//            // Need to ensure the app size has not increased
//            //manifestPlaceholders["crashlyticsEnabled"] = true
//            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
//            //resValue("string", "google_maps_key", "AIzaSyD5jqwKMm1SeoYsW25vxCXfTlhDBeZ4H5c")
//            //buildConfigField("String", "MAP_TILE_URL_BASE", "\"https://storage.googleapis.com/io2019-festivus-prod/images/maptiles\"")
//        }
//        getByName("debug") {
//            versionNameSuffix = "-debug"
//            //manifestPlaceholders["crashlyticsEnabled"] = false
//            //resValue("string", "google_maps_key", "AIzaSyAhJx57ikQH9rYc8IT8W3d2As5cGHMBvuo")
//            //buildConfigField("String", "MAP_TILE_URL_BASE", "\"https://storage.googleapis.com/io2019-festivus/images/maptiles\"")
//        }
//        maybeCreate("staging")
//        getByName("staging") {
//            // TODO: replace with initWith(getByName("debug")) in 7.0.0-beta04
//            // https://issuetracker.google.com/issues/186798050
//            this::class.memberFunctions.first { it.name == "initWith" }.call(this, getByName("debug"))
//            versionNameSuffix = "-staging"
//            // Specifies a sorted list of fallback build types that the
//            // plugin should try to use when a dependency does not include a
//            // "staging" build type.
//            // Used with :test-shared, which doesn't have a staging variant.
//            matchingFallbacks += listOf("debug")
//        }
//    }



//    signingConfigs {
//        // We need to sign debug builds with a debug key to make firebase auth happy
//        getByName("debug") {
//            storeFile = file("../debug.keystore")
//            keyAlias = "androiddebugkey"
//            keyPassword = "android"
//            storePassword = "android"
//        }
//
//
//        getByName("debug") {
//            storeFile = file("../debug.keystore")
//            keyAlias = "androiddebugkey"
//            keyPassword = "android"
//            storePassword = "android"
//        }
//    }

//    // debug and release variants share the same source dir
//    sourceSets {
//        getByName("debug") {
//            java.srcDir("src/debugRelease/java")
//        }
//        getByName("release") {
//            java.srcDir("src/debugRelease/java")
//        }
//    }



//    dokka {
//        outputFormat = 'javadoc'
//        outputDirectory = "$buildDir/docs"
//
//        configuration {
//            skipDeprecated = true
//            reportUndocumented = true
//            skipEmptyPackages = true
//
//            noJdkLink = true
//            noStdlibLink = true
//            noAndroidSdkLink = true
//        }
//    }

    buildFeatures {
        //compose = true
        //dataBinding = true
        viewBinding = true
    }


//    composeOptions {
//        kotlinCompilerExtensionVersion = "1.1.0-rc01"
//    }

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


dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))

    //implementation fileTree(include : [ "*.jar", '*.aar'], dir : "libs")
    //api rootProject.ext.dependencies["retrofit"]
    //testImplementation AndroidBuildSrc.Junit

    //runtimeOnly project(':module_login')
    //implementation project(':module_login')
    implementation(project(":module_login"))

    implementation(Dep.AndroidX.CoreKtx)
    implementation(Dep.AndroidX.AppCompat)
    implementation(Dep.UIMaterial.Material)
    implementation(Dep.AndroidX.ConstraintLayout)


    implementation(Dep.JetPack.HiltCore)

    kapt(Dep.GitHub.ARouteCompiler)
    kapt(Dep.GitHub.EventBusAPT)
    kapt(Dep.GitHub.AutoServiceAnnotations)
    kapt(Dep.JetPack.HiltApt)
    kapt(Dep.JetPack.HiltAndroidx)
    kapt(Dep.JetPack.LifecycleApt)



    testImplementation(Dep.DepsTest.Junit)
    androidTestImplementation(Dep.DepsTest.androidTestJunit)
    androidTestImplementation(Dep.DepsTest.espressoCore)
}


// 配置导出信息
//tasks.dokkaJavadoc.configure {
//    // 导出的文档目录路径
//    outputDirectory.set(new File(rootDir, "doc"))
//    dokkaSourceSets {
//        named("main") {
//            noAndroidSdkLink.set(true)
//            noStdlibLink.set(true)
//            noJdkLink.set(true)
//        }
//        configureEach {
//            // 包的定义
//            includes.from("packages.md")
//        }
//    }
//}

//dokkaHtml.configure {
//    String dokkaPath = projectDir.absolutePath.replace(rootDir.absolutePath, "")
//    outputDirectory.set(new File(rootDir.absolutePath + File.separator + "dokka" + dokkaPath))
//    dokkaSourceSets {
//        named("main") {
//            includeNonPublic.set(true)
//            noJdkLink.set(true)
//            noStdlibLink.set(true)
//            noAndroidSdkLink.set(true)
//            suppressInheritedMembers.set(true)
//            suppressObviousFunctions.set(false)
//        }
//    }
//}


//def implementationDependencies = project.ext.dependencies
//def processors = project.ext.annotationProcesso
//def implementationExcludes = project.ext.implementationExcludes
//dependencies {
//    // 处理所有的 xxximplementation 依赖
//    implementationDependencies.each { k, v -> implementation v }
//    // 处理 annotationProcessor 依赖
//    processors.each { k, v -> annotationProcessor v }
//    // 处理所有包含 exclude 的依赖
//    implementationExcludes.ååeach { entry ->
//        implementation(entry.key) {
//            entry.value.each { childEntry ->
//                exclude(group: childEntry)
//            }
//        }
//    }
//}

//val gitVersion = runCommand(project, "git rev-list HEAD --count").toIntOrNull() ?: 1
//
//fun runCommand(project: Project, command: String): String {
//    val stdout = java.io.ByteArrayOutputStream()
//    project.exec {
//        commandLine = command.split(" ")
//        standardOutput = stdout
//    }
//    return stdout.toString().trim()
//}

kapt {
    correctErrorTypes = true
    includeCompileClasspath = true
    arguments {
        arg("AROUTER_MODULE_NAME", project.name)
        arg("eventBusIndex", "eventbus.index.${project.name}EventIndex")
    }
}

//依赖库
//apply(from = "depends.gradle")

//task
//apply(from = "tasks.gradle")

//aop
//apply(from = "aopconfig.gradle")
