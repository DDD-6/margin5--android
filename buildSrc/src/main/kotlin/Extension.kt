import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementAll(list: List<String>) {
    list.forEach {
        add("implementation", it)
    }
}