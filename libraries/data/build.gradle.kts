import ProjectLibraries.domain

plugins {
    id("kotlin")
}

dependencies {
    implementation(project(domain))

    implementation(Dependencies.DI.javaxInject)
}