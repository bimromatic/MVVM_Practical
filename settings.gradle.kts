//includeBuild ("../VersionPlugin")
include(
        ":app",
        ":library_base",
        ":library_common",
        ":module_login",
)

includeBuild("plugin_version")

rootProject.name = "MVVM—Practical"

