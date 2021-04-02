import com.lomovskiy.lib.qrscan.buildsrc.Config

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("maven-publish")
}

android {

    defaultConfig {
        minSdkVersion(Config.Versions.Android.min)
        targetSdkVersion(Config.Versions.Android.target)
        compileSdkVersion(Config.Versions.Android.compile)
        buildToolsVersion(Config.Versions.buildTools)
        versionCode(Config.Versions.code)
        versionName(Config.Versions.name)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packagingOptions {
        exclude("META-INF/main.kotlin_module")
        exclude("META-INF/lib_release.kotlin_module")
    }

}

dependencies {

    implementation(Config.Libs.kotlinStd)
    implementation(Config.Libs.ui)
    implementation(Config.Libs.zxingCore)
    implementation(Config.Libs.zxingAndroidEmbedded)

}

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(android.sourceSets.getByName("main").java.srcDirs)
}

artifacts {
    archives(sourcesJar)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = Config.Publish.groupId
                artifactId = Config.Publish.artifactId
                version = Config.Versions.name
            }
        }
    }
}
