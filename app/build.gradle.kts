import ProjectLibraries.core
import ProjectLibraries.data
import ProjectLibraries.domain
import ProjectLibraries.local
import ProjectLibraries.navigator
import ProjectLibraries.remote

//https://gist.github.com/f3401pal/8aa468192a4d35642e20abf9dbd8de4c
plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
    id("com.google.gms.google-services")
    //apply(from = "../android.gradle.kts")
}

dependencies {
    implementation(project(core))
    implementation(project(domain))
    implementation(project(data))
    implementation(project(remote))
    implementation(project(local))

    implementation(project(navigator))

    implementation(Dependencies.DI.hiltAndroid)
    kapt(Dependencies.DI.hiltCompiler)

    implementation(Dependencies.Coroutines.core)

    implementation(project(Features.splash))
    implementation(project(Features.main))
    implementation(project(Features.thumbnail))
    implementation(project(Features.sign))
    implementation(project(Features.write))

    implementation(project(Features.detail))

    platform("com.google.firebase:firebase-bom:29.0.0")
    
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")

    //Room
    val room_version = "2.3.0"
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")

    kapt("androidx.room:room-compiler:$room_version")

    implementation(Dependencies.Navigation.fragmentKtx)
    implementation(Dependencies.Navigation.uiKtx)

    // Feature module Support
    //implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")

    // Testing Navigation
    //androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")


    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}