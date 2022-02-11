import com.bimromatic.plugin.Dep

buildscript {
    repositories {
        mavenCentral()
        //google()
        mavenLocal()
        //maven(url = "http://localhost:8081/artifactory/agent_group/")
        maven{
            setAllowInsecureProtocol(true)
            //isAllowInsecureProtocol = true//属性解决 gradle 的仓库地址不安全警告
            setUrl( "http://localhost:8081/artifactory/android_agent_group/")
        }

    }
    dependencies {
        classpath(ProjectPlugin.AndroidGradleToolsPlugin)
        classpath(ProjectPlugin.KotlinPlugin)
        classpath(ProjectPlugin.DokkaGradle)
        classpath(ProjectPlugin.HiltPlugin)
        classpath(ProjectPlugin.ARouterRegister)
        classpath(ProjectPlugin.GradleMavenPublish)
        classpath(ProjectPlugin.GradleVersionsPlugin)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.md.kts files
    }
}

plugins {
    // 这个 id 就是在 versionPlugin 文件夹下 build.gradle.md.kts 文件内定义的id
    id("plugin.version")apply (false)
    id("dep-plugin")apply (false)
}

subprojects{
    group = Dep.group
    println("${this.project.name}")

    afterEvaluate {
        //plugins.hasPlugin()
        when(project.name){
            "app" ->{
                println("模版分类")
            }
        }
    }
}

@Suppress("UnstableApiUsage")
allprojects {
    repositories {
        //阿里新老仓库更换对比 todo https://maven.aliyun.com/mvn/guide
        mavenCentral()
        //google()
        //maven("https://maven.aliyun.com/repository/public")
        //maven("https://maven.aliyun.com/repository/google")
        //maven("https://maven.aliyun.com/repository/gradle-plugin")
        //maven(url = "http://localhost:8081/artifactory/agent_group/")
        maven{
            setAllowInsecureProtocol(true)
            //isAllowInsecureProtocol = true
            setUrl( "http://localhost:8081/artifactory/android_agent_group/")
        }
    }
}

tasks.register("clean", Delete::class.java){
    delete(rootProject.buildDir)
}














