pluginManagement {
    includeBuild("build-logic")
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
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
    }
}


dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "minimasocial"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":app")

include(":core:common")
include(":core:data")
include(":core:database")
include(":core:datastore")
include(":core:designsystem")
include(":core:domain")
include(":core:model")
include(":core:navigation")
include(":core:network")
include(":core:ui")

include(":feature:auth:splash:api")
include(":feature:auth:splash:impl")

include(":feature:auth:login:api")
include(":feature:auth:login:impl")

include(":feature:auth:register:impl")
include(":feature:auth:register:api")

include(":feature:home:api")
include(":feature:home:impl")

include(":feature:search:api")
include(":feature:search:impl")

include(":feature:profile:api")
include(":feature:profile:impl")

include(":feature:post:create:api")
include(":feature:post:create:impl")

include(":feature:post:edit:api")
include(":feature:post:edit:impl")

include(":feature:post:view:api")
include(":feature:post:view:impl")

