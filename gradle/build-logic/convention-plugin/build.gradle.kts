plugins {
    `kotlin-dsl`
}

group = "ru.custom.buildlogic"

// This repositories are required to connect non-official
repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {

    compileOnly(libs.plugin.android)
    compileOnly(libs.gradlePlugins.kotlin.core)
    compileOnly(libs.gradle.versions.plugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.gradlePlugins.jb.compose)
    /*
    * compileOnly makes it impossible to load class
    * for my custom plugin if i loaded the settings.gradle.kts plugin
    * You also need to remove the loading of plugins in the project block
     */
    implementation(libs.detekt.plugin)
    implementation(libs.ktlint.jlleitschuh.plugin)
    implementation(libs.spotless.plugin)

    // TODO подождать пока эта фича появится в гредле
    // Мы хотим получать доступ к libs из наших convention плагинов, но гредл на текущий момент не умеет прокидывать
    // version catalogs. Поэтому используем костыль отсюда - https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "custom.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidCompose") {
            id = "custom.android.application.compose"
            implementationClass = "AndroidComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "custom.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("multiplatformLibrary") {
            id = "custom.multiplatformLibrary"
            implementationClass = "MultiplatformLibraryConventionPlugin"
        }
        register("androidMultiplatformLibrary") {
            id = "custom.androidMultiplatformLibrary"
            implementationClass = "AndroidOnlyLibraryConventionPlugin"
        }
        register("androidComposeLibrary") {
            id = "custom.android.compose.library"
            implementationClass = "AndroidComposeLibraryConventionPlugin"
        }
        register("androidAppQualityPlugin") {
            id = "custom.android.codequality"
            implementationClass = "CodeQualityConventionPlugin"
        }
        register("androidSettingsProject") {
            id = "custom.settings"
            implementationClass = "ProjectStructurePlugin"
        }
        register("gradleVersionsPlugin") {
            id = "custom.gradleVersionPlugin"
            implementationClass = "helpers.GradleVersionsPlugin"
        }
        register("koinPlugin") {
            id = "custom.koinPlugin"
            implementationClass = "KoinAnnotationConventionPlugin"
        }
        register("ktorfitPlugin") {
            id = "custom.ktorfitPlugin"
            implementationClass = "KtorfitConventionPlugin"
        }
        register("featureApiPlugin") {
            id = "custom.featureApi"
            implementationClass = "FeatureApiPlugin"
        }
        register("featureInternalPlugin") {
            id = "custom.featureInternal"
            implementationClass = "FeatureInternalPlugin"
        }
    }
}