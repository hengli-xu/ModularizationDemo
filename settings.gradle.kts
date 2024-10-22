pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "ModularizationDemo"
include(":app")

include(":common:imageloader")

include(":core:api-feature")
include(":core:datamodel")
include(":core:data")
include(":core:domain")
include(":core:network")

include(":feature:homepage")
include(":feature:profile")
include(":core:base")
