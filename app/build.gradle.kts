plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Apps.compileSdk)
    buildToolsVersion = "29.0.1"
    defaultConfig {
        applicationId = "com.test.currencyconverter"
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        versionCode = Apps.versionCode
        versionName = Apps.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )

        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Libs.kotlin)
    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.AndroidX.core)
    implementation(Libs.AndroidX.constraintLayout)
    implementation(Libs.AndroidX.lifeCycle)
    implementation(Libs.AndroidX.recyclerView)

    //Rx Kotlin and Android
    implementation(Libs.rxJava)

    //Retrofit
    implementation(Libs.retrofit)

    //Dagger
    implementation(Libs.dagger)
    kapt(Libs.daggerCompiler)

    implementation(project(":core"))
}
