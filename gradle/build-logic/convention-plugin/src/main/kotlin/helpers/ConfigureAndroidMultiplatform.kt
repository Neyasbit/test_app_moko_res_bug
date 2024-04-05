package helpers

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Configure base Kotlin with Android options
 */

internal fun Project.configureAndroidMultiplatform(
    commonExtension: CommonExtension<*, *, *, *, *>,
) {

    commonExtension.apply {
        compileSdk = AndroidVersions.COMPILE_SDK

        defaultConfig {
            minSdk = AndroidVersions.MIN_SDK
        }

        compileOptions {
            // Flag to enable support for the new language APIs
            isCoreLibraryDesugaringEnabled = true
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

        sourceSets {
            getByName("main") {
                java.srcDirs("src/kotlin")
                kotlin.srcDirs("src/kotlin")
                manifest.srcFile("src/androidMain/AndroidManifest.xml")
            }
        }

        namespace = (group.toString() +
                path).replace("-", "").split(":").joinToString(".")

        tasks.named("preBuild") {
            /**
             * just to check in which module the tasks are executed
             */
            val name = "${project.parent?.name}:${project.name}"
            println("inside tasks -> $name")
            //does not work with moko res and i don't know even how to fix it yet
            //dependsOn("ktlintFormat")
            dependsOn("spotlessCheck")
            dependsOn("spotlessApply")
            //dependsOn("detekt")
        }

        dependencies {
            val bom = libs.findLibrary("desugar-jdk-libs").get()
            add("coreLibraryDesugaring", platform(bom))
        }
    }
}
