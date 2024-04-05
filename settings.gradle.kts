pluginManagement {
    includeBuild("gradle/build-logic")
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "test_app_moko_res_bug"
include(
    ":androidApp",
    ":di",
    ":core:base",
    ":core:decompose",
    ":core:design",
    ":core:resources",
    ":features:test:main:component-api",
    ":features:test:main:component-internal",
    ":features:test:root:component-internal",
    ":features:test:root:component-api",
    ":features:root:presentation",
)



