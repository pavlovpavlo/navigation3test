pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "NavigationThreeTest"
include(":app")
include(":feature:splash")
include(":feature:onboarding")
include(":feature:tabs")
include(":feature:products")
include(":core:navigation")
include(":core:ui")
