import com.bimromatic.plugin.Dep
import java.io.ByteArrayOutputStream
import java.util.*

plugins{
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
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

    buildTypes {
        release {
            isMinifyEnabled=false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

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
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))

    //api  Dep.BimromaticLib.LibBase
    api(Dep.JetPack.HiltCore)
    kapt(Dep.GitHub.ARouteCompiler)
    kapt(Dep.GitHub.EventBusAPT)
    kapt(Dep.GitHub.AutoServiceAnnotations)
    kapt(Dep.JetPack.HiltApt)
    kapt(Dep.JetPack.HiltAndroidx)
    kapt(Dep.JetPack.LifecycleApt)
    kapt(Dep.JetPack.RoomCompiler)

    api(Dep.BimromaticLib.LibBase)
    //api(project(":library_base"))
    api(project(":library_theme"))
}

kapt {
    arguments {
        arg("AROUTER_MODULE_NAME", project.name)
        arg("eventBusIndex", "eventbus.index.${project.name}EventIndex")
    }
}
