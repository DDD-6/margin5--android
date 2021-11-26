import ProjectLibraries.core
import ProjectLibraries.domain
import ProjectLibraries.navigator

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(project(core))
    implementation(project(domain))
    implementation(project(navigator))

    implementation(Dependencies.DI.hiltAndroid)
    kapt(Dependencies.DI.hiltCompiler)

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.fragment:fragment-ktx:1.4.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("io.coil-kt:coil:1.4.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}