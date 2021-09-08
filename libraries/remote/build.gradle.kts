import ProjectLibraries.data

plugins {
    id("kotlin")
}

dependencies {
    implementation(project(data))

    implementAll(Dependencies.Remote.components)
}