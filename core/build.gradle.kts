plugins {
    id("java-library")
    id("kotlin")
    kotlin("kapt")

}
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Libs.kotlin)

    //Rx Kotlin and Android
    implementation(Libs.rxJava)

    //Dagger
    implementation(Libs.dagger)
    kapt(Libs.daggerCompiler)

    //Retrofit
    implementation(Libs.retrofit)

    // Gson
    implementation(Libs.gson)
}
