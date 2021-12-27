import com.bimromatic.plugin.Dep

buildscript {
    repositories {
        mavenCentral()
        google()
        mavenLocal()
    }
    dependencies {
        classpath(ProjectPlugin.AndroidGradleToolsPlugin)
        classpath(ProjectPlugin.KotlinPlugin)
        classpath(ProjectPlugin.DokkaGradle)
        classpath(ProjectPlugin.HiltPlugin)
        classpath(ProjectPlugin.ARouterRegister)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

plugins {
    // 这个 id 就是在 versionPlugin 文件夹下 build.gradle.kts 文件内定义的id
    id("plugin.version")apply false
    id("plugin-dep")apply false
}

subprojects{
    group = Dep.group
    println("${this.project.name}")
}

allprojects {
    repositories {
        //阿里新老仓库更换对比 todo https://maven.aliyun.com/mvn/guide
        google()
        mavenCentral()
        maven("https://maven.aliyun.com/repository/public")
        maven("https://maven.aliyun.com/repository/google")
        maven("https://maven.aliyun.com/repository/gradle-plugin")
    }
}

tasks.register("clean", Delete::class.java){
    delete(rootProject.buildDir)
}









