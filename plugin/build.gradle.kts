import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
//import com.bimromatic.plugin.Dep

plugins {
    `java-gradle-plugin`
    idea
    kotlin("jvm") version "1.6.10"
    `kotlin-dsl`
    `maven-publish`
    `signing`
}



buildscript {
    repositories {
        mavenCentral()
        google()
        mavenLocal()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    }
}


group = "com.bimromatic"
version = "0.0.1"


gradlePlugin {
    plugins {
        create("dep-plugin"){
            id = "dep-plugin"
            implementationClass = "com.bimromatic.plugin.VersionPlugin"
        }

        create("dep-publish"){
            id = "dep-publish"
            implementationClass = "com.bimromatic.plugin.PublishPlugin"
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
    api(kotlin("gradle-plugin", version = "1.6.10"))
    api(kotlin("gradle-plugin-api", version = "1.6.10"))
    api("com.android.tools.build:gradle-api:7.0.4")
    api("com.android.tools.build:gradle:7.0.4")
    implementation(kotlin("stdlib-jdk8"))

    implementation("com.google.code.gson:gson:2.8.6")//这几个是一会需要用到的库
    implementation("net.dongliu:apk-parser:2.6.9")
    implementation("dom4j:dom4j:1.6.1")
    implementation("com.squareup.okio:okio:2.10.0")
    implementation("javax.activation:activation:1.1.1")//ps:jdk11后需要手动引用
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

//sourceSets.main {
//    java.srcDirs("src/main/kotlin")
//}
//
//sourceSets.test {
//    java.srcDirs("src/test/kotlin")
//}
//
//tasks.withType<GenerateModuleMetadata> {
//    enabled = false
//}
//
//publishing {
//    val ossrhUsername: String by project
//    val ossrhPassword: String by project
//
//    repositories {
//        maven(url = "https://oss.sonatype.org/service/local/staging/deploy/maven2/") {
//            credentials {
//                username = ossrhUsername
//                password = ossrhPassword
//            }
//        }
//    }
//    publications {
//        group = "com.bimromatic"
//        version = "0.0.1"
//        create<MavenPublication>("mavenJava") {
//            pom {
//                name.set("bom-plugin")
//                description.set("A library to help apply tdd through help functions");
//                url.set("https://thiagosouto.dev")
//
//                licenses {
//                    license {
//                        name.set("The Apache License, Version 2.0")
//                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
//                    }
//                }
//
//                scm {
//                    connection.set("scm:git:git://github.com/othiagosouto/bom-plugin.git/")
//                    developerConnection.set("scm:git:ssh://github.com:othiagosouto/bom-plugin.git")
//                    url.set("https://github.com/othiagosouto/bom-plugin")
//                }
//                developers {
//                    developer {
//                        id.set("othiagosouto")
//                        name.set("Thiago Souto silva de barros Santos")
//                        email.set("soutosss@gmail.com")
//                    }
//                }
//            }
//        }
//    }
//}
//afterEvaluate {
//    signing {
//        sign(publishing.publications["mavenJava"])
//    }
//}




//allprojects {
//    plugins.withId("com.vanniktech.maven.publish") {
//    }
//}

//publishing{
//
//    publications{
//
//        repositories {
//            maven{
//                val releasesRepoUrl = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
//                val snapshotsRepoUrl = uri("https://oss.sonatype.org/content/repositories/snapshots/")
//                val url = uri(if (project.hasProperty("release")) releasesRepoUrl else snapshotsRepoUrl)
//            }
//        }
//    }
//
//}


//group = "com.example"
//version = "1.0"

//java {
//    withJavadocJar()
//    withSourcesJar()
//}

//publishing {
//    publications {
//        create<MavenPublication>("mavenJava") {
//            groupId = "com.bimromatic"
//            artifactId = "dep-plugin"
//            version = "0.0.1"
//            from(components["java"])
//            versionMapping {
//                usage("java-api") {
//                    fromResolutionOf("runtimeClasspath")
//                }
//                usage("java-runtime") {
//                    fromResolutionResult()
//                }
//            }
//            pom {
//                name.set("dep-plugin")
//                description.set("A concise description of my library")
//                url.set("https://github.com/bimromatic/MVVM_Practical")
//                properties.set(mapOf(
//                    "myProp" to "value",
//                    "prop.with.dots" to "anotherValue"
//                ))
//                licenses {
//                    license {
//                        name.set("The Apache License, Version 2.0")
//                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
//                    }
//                }
//                developers {
//                    developer {
//                        id.set("bimromatic")
//                        name.set("bimromatic")
//                        email.set("953364885@qq.com")
//                    }
//                }
//                scm {
//                    connection.set("scm:git:github://bimromatic/MVVM_Practical.git")
//                    developerConnection.set("scm:git:ssh://github.com/bimromatic/MVVM_Practical.git")
//                    url.set("https://github.com/bimromatic/MVVM_Practical/tree/master")
//                }
//            }
//        }
//    }
//    repositories {
//        maven {
//            // change URLs to point to your repos, e.g. http://my.org/repo
//            //val releasesRepoUrl = uri(layout.buildDirectory.dir("repos/releases"))
//            val releasesRepoUrl = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
//            //val snapshotsRepoUrl = uri(layout.buildDirectory.dir("repos/snapshots"))
//            val snapshotsRepoUrl = uri("https://oss.sonatype.org/content/repositories/snapshots/")
//            val url = uri(if (project.hasProperty("release")) releasesRepoUrl else snapshotsRepoUrl)
//            //url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
//        }
//    }
//}
//
//signing {
//    sign(publishing.publications["mavenJava"])
//}
//
//tasks.javadoc {
//    if (JavaVersion.current().isJava9Compatible) {
//        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
//    }
//}



















//publishing {
//    publications {
//        create<MavenPublication>("mavenJava") {
//            artifactId = "dep-plugin"
//            from(components["java"])
//            versionMapping {
//                usage("java-api") {
//                    fromResolutionOf("runtimeClasspath")
//                }
//                usage("java-runtime") {
//                    fromResolutionResult()
//                }
//            }
//            pom {
//                name.set("My Library")
//                description.set("A concise description of my library")
//                url.set("http://www.example.com/library")
//                properties.set(mapOf(
//                    "myProp" to "value",
//                    "prop.with.dots" to "anotherValue"
//                ))
//                licenses {
//                    license {
//                        name.set("The Apache License, Version 2.0")
//                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
//                    }
//                }
//                developers {
//                    developer {
//                        id.set("bimromatic")
//                        name.set("bimromatic")
//                        email.set("953364885@qq.com")
//                    }
//                }
//                scm {
//                    connection.set("scm:git:git://example.com/my-library.git")
//                    developerConnection.set("scm:git:ssh://example.com/my-library.git")
//                    url.set("http://example.com/my-library/")
//                }
//            }
//        }
//    }
//    repositories {
//        maven {
//            // change URLs to point to your repos, e.g. http://my.org/repo
//            val releasesRepoUrl = uri(layout.buildDirectory.dir("repos/releases"))
//            val snapshotsRepoUrl = uri(layout.buildDirectory.dir("repos/snapshots"))
//            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
//        }
//    }
//}
//
//signing {
//    sign(publishing.publications["mavenJava"])
//}
//
//tasks.javadoc {
//    if (JavaVersion.current().isJava9Compatible) {
//        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
//    }
//}





//tasks.withType<KotlinCompile>() {
//    kotlinOptions.jvmTarget = "1.8"
//}

////声明打包源码，如果不想上传源码，可以不必配置
//java {
//    withSourcesJar()
//    //注释支持
//    withJavadocJar()
//}

//// sources
//tasks.register('sourcesJar', Jar) {
//    archiveClassifier.set('sources')
//    from android.sourceSets.main.java.sourceFiles
//}
//
//// javadoc
//tasks.register('androidJavadoc', Javadoc) {
//    source = android.sourceSets.main.java.srcDirs
//    classpath += project.files(android.getBootClasspath().join(File.pathSeparator))
//}
//tasks.register('javadocJar', Jar) {
//    dependsOn androidJavadoc
//            archiveClassifier.set('javadoc')
//    from androidJavadoc.destinationDir
//}




/*
https://stackoverflow.com/questions/66684329/could-not-put-https-oss-sonatype-org-service-local-staging-deploy-maven2-bom-p
*/

//sourceSets.main {
//    java.srcDirs("src/main/kotlin")
//}
//
//sourceSets.test {
//    java.srcDirs("src/test/kotlin")
//}
//
//
//tasks.withType<GenerateModuleMetadata> {
//    enabled = false
//}
//
//
//publishing {
//    val ossrhUsername: String by project
//    val ossrhPassword: String by project
//
//    repositories {
//        maven(url = "https://oss.sonatype.org/service/local/staging/deploy/maven2/") {
//            credentials {
//                username = ossrhUsername
//                password = ossrhPassword
//            }
//        }
//    }
//    publications {
//        group = "com.bimromatic"
//        version = "0.0.1"
//        create<MavenPublication>("mavenJava") {
//            pom {
//                name.set("version-plugin")
//                description.set("A library to help apply tdd through help functions");
//                url.set("https://bimromatic.com")
//
//                licenses {
//                    license {
//                        name.set("The Apache License, Version 2.0")
//                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
//                    }
//                }
//
//                scm {
//                    connection.set("scm:git:git://github.com/othiagosouto/bom-plugin.git/")
//                    developerConnection.set("scm:git:ssh://github.com:othiagosouto/bom-plugin.git")
//                    url.set("https://github.com/othiagosouto/bom-plugin")
//                }
//                developers {
//                    developer {
//                        id.set("othiagosouto")
//                        name.set("Thiago Souto silva de barros Santos")
//                        email.set("soutosss@gmail.com")
//                    }
//                }
//            }
//        }
//    }
//}
//afterEvaluate {
//    signing {
//        sign(publishing.publications["mavenJava"])
//    }
//}


//publishing {
//    publications {
//        create<MavenPublication>("maven") {
//            groupId = "com.bimromatic.plugin"
//            artifactId = "version_plugin"
//            version = "0.0.1"
//            from(components["java"])
//        }
//    }
//}







