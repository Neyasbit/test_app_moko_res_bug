plugins {
    alias(libs.plugins.custom.android.library)
    alias(libs.plugins.custom.multiplatform.library)
    alias(libs.plugins.custom.android.codequality)
    alias(libs.plugins.moko.resources)
    id(libs.plugins.cocoapods.get().pluginId)
}
kotlin {

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "15"
        framework {
            baseName = "resources"
            isStatic = true
            export(libs.moko.resources)
            export(libs.moko.graphics)
        }
    }
    sourceSets {
        commonMain {
            dependencies {
                api(libs.moko.resources)
                api(libs.moko.resources.compose)
            }
        }
        val androidMain by getting {
            dependsOn(commonMain.get())
        }
        val iosMain by getting {
            dependsOn(commonMain.get())
        }
        val iosArm64Main by getting {
            dependsOn(iosMain)
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
        val iosX64Main by getting {
            dependsOn(iosMain)
        }
    }
}

multiplatformResources {
    resourcesPackage.set("ru.test.resources") // required
    resourcesClassName.set("Resources") // optional, default MR
    iosBaseLocalizationRegion.set("ru") // optional, default "en"
}