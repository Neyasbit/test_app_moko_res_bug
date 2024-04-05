plugins {
    alias(libs.plugins.custom.android.library)
    alias(libs.plugins.custom.multiplatform.library)
    alias(libs.plugins.custom.android.codequality)
    alias(libs.plugins.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(compose.material)
            implementation(compose.material3)
            implementation(libs.arkivanov.essenty.lifecycle.coroutines)
            implementation(libs.arkivanov.essenty.lifecycle)
            implementation(libs.kotlinx.coroutines.core)

            implementation(projects.core.resources)
        }
    }
}