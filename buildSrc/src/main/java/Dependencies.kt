import org.gradle.api.artifacts.dsl.DependencyHandler

object Apps {
    const val compileSdk = 29
    const val minSdk = 22
    const val targetSdk = 29
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val gradle = "3.5.2"
    const val kotlin = "1.3.50"
    const val appcompat = "1.1.0"
    const val coreKtx = "1.1.0"
    const val constraintsLayout = "1.1.3"
    const val lifecycleExtension = "2.1.0"
    const val recyclerView = "1.0.0"
    const val rxKotlin = "2.4.0"
    const val rxAndroid = "2.1.1"
    const val retrofit = "2.6.2"
    const val dagger = "2.25.2"
    const val daggerAndroid = "2.24"
    const val gson = "2.8.5"
}

object Libs {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val core = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintsLayout}"
        const val lifeCycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtension}"
        const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    }

    val rxJava = arrayOf(
        "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}",
        "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    )
    val retrofit = arrayOf(
        "com.squareup.retrofit2:retrofit:${Versions.retrofit}",
        "com.squareup.retrofit2:converter-gson:${Versions.retrofit}",
        "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    )

    val dagger = arrayOf(
        "com.google.dagger:dagger:${Versions.dagger}",
        "com.google.dagger:dagger-android:${Versions.daggerAndroid}",
        "com.google.dagger:dagger-android-support:${Versions.daggerAndroid}"
    )

    val daggerCompiler = arrayOf(
        "com.google.dagger:dagger-android-processor:${Versions.daggerAndroid}",
        "com.google.dagger:dagger-compiler:${Versions.dagger}"
    )

}

/**
 * DependencyHandler extensions
 */

fun DependencyHandler.implementation(dependencyNotations: Array<String>) {
    dependencyNotations.forEach { add("implementation", it) }
}

fun DependencyHandler.kapt(dependencyNotations: Array<String>) {
    dependencyNotations.forEach { add("kapt", it) }
}