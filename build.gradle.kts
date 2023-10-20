// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath  ("com.google.gms:google-services:4.3.13")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.1")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.42'")
    }
}


plugins {
    id ("com.android.application") version "7.1.2" apply false
    id ("com.android.library") version "7.1.2" apply false
    id ("org.jetbrains.kotlin.android") version "1.5.30" apply false
}

task clean(type: Delete) {
    delete rootProject.buildDir
}