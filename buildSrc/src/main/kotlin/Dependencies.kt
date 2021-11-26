
object Dependencies {

    object DI {
        object Version {
            const val javaxInject = "1"
            const val hiltVersion = "2.40.2"
            const val hiltAndroidVersion = "1.0.0-alpha01"
        }

        const val javaxInject = "javax.inject:javax.inject:${Version.javaxInject}"

        const val hiltAndroid = "com.google.dagger:hilt-android:${Version.hiltVersion}"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:${Version.hiltVersion}"
        const val hiltAndroidCompiler = "androidx.hilt:hilt-compiler::${Version.hiltAndroidVersion}"
    }

    object Navigation {
        object Version {
            const val navigation = "2.4.0-beta02"
        }

        const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
        const val uiKtx = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
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

    object FeatureCore : Libraries {
        override val components: List<String>
            get() = listOf(
                DI.hiltAndroid,
                DI.hiltCompiler
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
    const val write = ":feature:note:write"
    const val detail = ":feature:note:detail"
    const val wine = ":feature:wine"
}