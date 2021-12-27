
/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/27
 * desc   :
 * version: 1.0
 * Link    :
 */

object ProjectPlugin {
    val AndroidGradleToolsPlugin by lazy { "com.android.tools.build:gradle:7.0.4" }
    val AndroidToolsPlugin by lazy { "com.android.tools.build:gradle:4.2.1" }
    val KotlinPlugin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21" }
    val ARouterRegister by lazy { "com.alibaba:arouter-register:1.0.2" }
    val HiltPlugin by lazy { "com.google.dagger:hilt-android-gradle-plugin:2.38.1" }
    val DokkaGradle by lazy { "org.jetbrains.dokka:dokka-gradle-plugin:1.6.0" }
}

object GradlePluginId{
    const val ANDROID_DYNAMIC_FEATURE = "com.android.dynamic-feature"
    const val KOTLIN_ANDROID = "org.jetbrains.kotlin.android"
    const val KOTLIN_KAPT = "kotlin-kapt"
    const val SAFE_ARGS = "androidx.navigation.safeargs.kotlin"
    const val DETEKT = "io.gitlab.arturbosch.detekt"
    const val KTLINT_GRADLE = "org.jlleitschuh.gradle.ktlint"
    const val ANDROID_JUNIT_5 = "de.mannodermaus.android-junit5"
    const val VersionPlugin = "plugin.version"
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val HiltPlugin = "dagger.hilt.android.plugin"
    const val DokkaPlugin = "org.jetbrains.dokka"
    const val AndroidPlugin = "android"
    const val kaptPlugin = "kapt"

}