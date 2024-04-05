plugins {
    alias(libs.plugins.custom.android.application)
    alias(libs.plugins.compose)
    alias(libs.plugins.custom.android.codequality)
    alias(libs.plugins.devtools.ksp)
}

android {
    namespace = "ru.test.event.android"
    defaultConfig {
        applicationId = "ru.test.event.android"
        versionCode = 1
        versionName = "1.0" // X.Y.Z; X = Major, Y = minor, Z = Patch level
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            excludes.add("/META-INF/ktor-http.kotlin_module")
            excludes.add("/META-INF/kotlinx-io.kotlin_module")
            excludes.add("/META-INF/atomicfu.kotlin_module")
            excludes.add("/META-INF/ktor-utils.kotlin_module")
            excludes.add("/META-INF/kotlinx-coroutines-io.kotlin_module")
            excludes.add("/META-INF/ktor-client-core.kotlin_module")
        }
    }
}

dependencies {
    // Compose
    implementation(libs.bundles.android.compose)
    coreLibraryDesugaring(libs.desugar.jdk.libs)

    implementation(libs.koin.android)

    // Decompose
    implementation(libs.arkivanov.decompose)

    implementation(projects.di)
    implementation(projects.features.root.presentation)

}
