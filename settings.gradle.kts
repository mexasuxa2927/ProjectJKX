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
        mavenCentral()
    }

}

rootProject.name = "MovieApp"
include(":app")
include(":NoSwipeViewPager")
include(":NoSwipeableViewPager")
