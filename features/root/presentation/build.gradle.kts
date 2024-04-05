plugins {
    alias(libs.plugins.custom.android.library)
    alias(libs.plugins.custom.multiplatform.library)
    alias(libs.plugins.custom.android.codequality)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.compose)
    alias(libs.plugins.custom.koin.plugin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.arkivanov.decompose)
            implementation(libs.arkivanov.decompose.extensions.compose)
            implementation(compose.material)
            implementation(compose.material3)

            implementation(projects.core.resources)
            implementation(projects.core.decompose)
            implementation(projects.features.test.root.componentApi)
            implementation(projects.core.design)
        }
    }
}