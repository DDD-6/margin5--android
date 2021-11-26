import ProjectLibraries.core
import ProjectLibraries.domain
import ProjectLibraries.navigator

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

dependencies {
    implementation(project(core))
    implementation(project(domain))
    implementation(project(navigator))

    implementation(project(Features.thumbnail))

    implementation(project(Features.wine))

    implementation(project(Features.write))
    implementation(project(Features.detail))

    implementation(Dependencies.DI.hiltAndroid)
    kapt(Dependencies.DI.hiltCompiler)

    implementation(Dependencies.Coroutines.core)

    kapt("org.xerial:sqlite-jdbc:3.34.0")

    val nav_version = "2.3.5"

    // Kotlin
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.fragment:fragment-ktx:1.4.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}