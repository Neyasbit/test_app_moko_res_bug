plugins {
    alias(libs.plugins.custom.android.library)
    alias(libs.plugins.custom.multiplatform.library)
    alias(libs.plugins.custom.android.codequality)
    alias(libs.plugins.compose)
    alias(libs.plugins.custom.koin.plugin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.arkivanov.decompose)
            implementation(libs.arkivanov.decompose.extensions.compose)
            implementation(libs.arkivanov.essenty.lifecycle.coroutines)
            implementation(libs.kotlinx.coroutines.core)
            implementation(compose.material)
            implementation(compose.material3)

            implementation(projects.core.decompose)
            implementation(projects.core.design)
            implementation(projects.features.test.main.componentApi)
            implementation(projects.core.resources)
        }
    }
}

android.namespace = "ru.test.main"