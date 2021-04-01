import com.lomovskiy.lib.qrscan.buildsrc.Config

plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {

    defaultConfig {
        applicationId("com.lomovskiy.lib.qrscan.sample")
        minSdkVersion(com.lomovskiy.lib.qrscan.buildsrc.Config.Versions.Android.min)
        targetSdkVersion(com.lomovskiy.lib.qrscan.buildsrc.Config.Versions.Android.target)
        compileSdkVersion(com.lomovskiy.lib.qrscan.buildsrc.Config.Versions.Android.compile)
        buildToolsVersion(com.lomovskiy.lib.qrscan.buildsrc.Config.Versions.buildTools)
        versionCode(com.lomovskiy.lib.qrscan.buildsrc.Config.Versions.code)
        versionName(com.lomovskiy.lib.qrscan.buildsrc.Config.Versions.name)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":lib"))
    implementation("com.github.lomovskiy:android-lib-ui:1.0.8")
}