import ProjectLibraries.domain

plugins {
    id("kotlin")
}

dependencies {
    implementation(project(domain))
    implementation(Dependencies.Coroutines.core)
    implementation(Dependencies.DI.javaxInject)
}