import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-gradle-plugin`
    idea
    kotlin("jvm") version "1.6.0"
    `kotlin-dsl`
}

buildscript {
    repositories {
        mavenCentral()
        google()
        mavenLocal()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
    }
}


group = "com.bimromatic.plugin"
version = "0.0.1"


gradlePlugin {
    plugins {
        create("plugin-dep"){
            id = "plugin-dep"
            implementationClass = "com.bimromatic.plugin.VersionPlugin"
        }

        create("version-publish"){
            id = "version-publish"
            implementationClass = "com.qmuiteam.plugin.QMUIPublish"
        }
    }
}

repositories {
    mavenCentral()
    google()
}


dependencies {
    api(gradleApi())
    api(gradleKotlinDsl())
    api(kotlin("gradle-plugin", version = "1.6.0"))
    api(kotlin("gradle-plugin-api", version = "1.6.0"))
    api("com.android.tools.build:gradle-api:7.0.4")
    api("com.android.tools.build:gradle:7.0.4")
    implementation(kotlin("stdlib-jdk8"))
}

//kotlinDslPluginOptions {
//    experimentalWarning.set(false)
//}


java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "11"
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

