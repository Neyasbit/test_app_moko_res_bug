plugins {
    alias(libs.plugins.custom.android.library)
    alias(libs.plugins.custom.multiplatform.library)
    alias(libs.plugins.custom.android.codequality)
    alias(libs.plugins.compose)
}
kotlin {
    sourceSets {
        commonMain.dependencies {
            api(compose.runtime)
            api(compose.material3)
        }
    }
}