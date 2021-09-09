dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Wine"
include(":app")

include(":libraries")
include(":libraries:domain")
include(":libraries:data")
include(":libraries:local")
include(":libraries:remote")

include(":feature")
include(":feature:main")
include(":feature:splash")

include(":core")
include(":libraries:navigator")
