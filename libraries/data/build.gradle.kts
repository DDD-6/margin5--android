import ProjectLibraries.domain

plugins {
    id("kotlin")
}

dependencies {
    implementation(project(domain))
}