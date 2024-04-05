plugins {
    alias(libs.plugins.custom.android.library)
    alias(libs.plugins.custom.multiplatform.library)
    alias(libs.plugins.custom.android.codequality)
    alias(libs.plugins.custom.koin.plugin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.arkivanov.mvikotlin.main)
            implementation(libs.arkivanov.mvikotlin)
            implementation(libs.arkivanov.mvikotlin.logging)

            implementation(projects.core.base)
            implementation(projects.features.root.presentation)
            implementation(projects.features.test.root.componentInternal)
            implementation(projects.features.test.main.componentInternal)
        }

        androidMain.dependencies {
            implementation(libs.koin.android)
        }
    }
}