
object Dependencies {

    object DI {
        object Version {
            const val javaxInject = "1"
            const val hiltVersion = "2.38.1"
        }

        const val javaxInject = "javax.inject:javax.inject:${Version.javaxInject}"

        const val hiltAndroid = "com.google.dagger:hilt-android:${Version.hiltVersion}"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:${Version.hiltVersion}"
    }

    object Coroutines {
        object Version {
            const val coroutines = "1.5.2"
        }

        const val core =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
    }

    object Domain : Libraries {
        override val components: List<String>
            get() = listOf(
                DI.javaxInject, Coroutines.core
            )
    }

    object Data : Libraries {
        override val components: List<String>
            get() = listOf(
                DI.javaxInject, Coroutines.core
            )
    }

    object Remote : Libraries {
        override val components: List<String>
            get() = listOf(
                DI.javaxInject, Coroutines.core
            )
    }

    object Local : Libraries {
        override val components: List<String>
            get() = listOf(
                DI.javaxInject, Coroutines.core
            )
    }
}

interface Libraries {
    val components: List<String>
}

object ProjectLibraries {
    const val core = ":core"

    const val domain = ":libraries:domain"
    const val data = ":libraries:data"
    const val remote = ":libraries:remote"
    const val local = ":libraries:local"

    const val navigator = ":libraries:navigator"
}

object Features {
    const val splash = ":feature:splash"
    const val sign = ":feature:sign"
    const val main = ":feature:main"
    const val thumbnail = ":feature:thumbnail"
}