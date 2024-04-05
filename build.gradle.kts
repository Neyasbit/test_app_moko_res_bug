buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.bundles.plugins)
        classpath(libs.spotless.plugin)
    }
}

plugins {
    alias(libs.plugins.compose) apply false
    alias(libs.plugins.devtools.ksp) apply false
    alias(libs.plugins.ktorfit) apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
