plugins {
    alias(libs.plugins.custom.android.library)
    alias(libs.plugins.custom.multiplatform.library)
    alias(libs.plugins.custom.android.codequality)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.decompose)
        }
    }
}