
object Dependencies {

    object DI {
        object Version {
            const val javaxInject: String = "1"
            const val hiltVersion: String = "2.38.1"
        }

        const val javaxInject: String = "javax.inject:javax.inject:${Version.javaxInject}"

        const val hiltAndroid = "com.google.dagger:hilt-android:${Version.hiltVersion}"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:${Version.hiltVersion}"
    }

    object Coroutines {
        object Version {
            const val coroutines: String = "1.5.2"
        }

        const val core: String =
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
    const val core: String = ":core"

    const val domain: String = ":libraries:domain"
    const val data: String = ":libraries:data"
    const val remote: String = ":libraries:remote"
    const val local: String = ":libraries:local"

    const val navigator: String = ":libraries:navigator"
}

object Features {
    const val splash: String = ":feature:splash"
    const val main: String = ":feature:main"
}