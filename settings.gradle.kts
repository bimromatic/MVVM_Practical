include(
        ":app",
        ":library_base",
        ":library_common",
        ":module_login",
        ":library_theme"
)

includeBuild("./plugin")
includeBuild("./plugin_version")
rootProject.name = "MVVM—Practical"



pluginManagement {
        repositories {
                mavenCentral()
        }
}
