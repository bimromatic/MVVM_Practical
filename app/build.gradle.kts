import java.io.ByteArrayOutputStream
import com.bimromatic.plugin.*

plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
    id(GradlePluginId.DokkaPlugin)
    kotlin(GradlePluginId.AndroidPlugin)
    kotlin(GradlePluginId.kaptPlugin)
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

    compileSdk = BuildConfig.compileSdkVersion


    compileOptions {
        sourceCompatibility = Dep.javaVersion
        targetCompatibility = Dep.javaVersion
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dep.Version.version
    }


    defaultConfig {
        applicationId = "com.bimromatic.mvvm_practical"
        minSdk=BuildConfig.minSdk
        targetSdk =BuildConfig.targetSdk
        versionCode =BuildConfig.versionCode
        versionName =BuildConfig.versionName
        //testInstrumentationRunner= BuildConfig.androidJUnitRunner
    }

    buildTypes {
        release {
            isMinifyEnabled=false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
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
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))

    //implementation fileTree(include : [ "*.jar", '*.aar'], dir : "libs")
    //api rootProject.ext.dependencies["retrofit"]
    //testImplementation AndroidBuildSrc.Junit

    implementation(AndroidX.CoreKtx)
    implementation(AndroidX.AppCompat)
    implementation(UIMaterial.Material)
    implementation(AndroidX.ConstraintLayout)

//    testImplementation Android.Junit
//    androidTestImplementation Android.androidTestJunit
//    androidTestImplementation Android.espressoCore


    //runtimeOnly project(':module_login')
    //implementation project(':module_login')
    implementation(project(":module_login"))


    testImplementation(DepsTest.Junit)
    androidTestImplementation(DepsTest.androidTestJunit)
    androidTestImplementation(DepsTest.espressoCore)
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