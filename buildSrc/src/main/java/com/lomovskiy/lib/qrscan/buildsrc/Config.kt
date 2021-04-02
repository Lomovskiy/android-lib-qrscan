package com.lomovskiy.lib.qrscan.buildsrc

object Config {

    object Publish {
        const val groupId = "com.lomovskiy.lib"
        const val artifactId = "qrscan"
    }

    object GradlePlugins {

        const val android: String = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
        const val kotlin: String = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    }

    object Versions {

        const val code = 2
        const val name = "1.0.1"

        object Android {

            const val target: Int = 30
            const val compile: Int = 30
            const val min: Int = 16

        }

        const val androidGradlePlugin: String = "4.1.2"
        const val buildTools: String = "30.0.3"

        const val kotlin: String = "1.4.30"
        const val ui: String = "1.0.8"
        const val qrScan: String = "1.0.0"
        const val zxing = "3.3.0"
        const val zxingAndroidEmbedded: String = "3.6.0"

    }

    object Libs {

        const val kotlinStd: String = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        const val ui: String = "com.github.lomovskiy:android-lib-ui:${Versions.ui}"
        const val qrScan: String = "com.github.Lomovskiy:android-lib-qrscan:${Versions.qrScan}"
        const val zxingCore: String = "com.google.zxing:core:${Versions.zxing}"
        const val zxingAndroidEmbedded: String = "com.journeyapps:zxing-android-embedded:${Versions.zxingAndroidEmbedded}"

    }

}
