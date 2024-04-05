package helpers

import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

/**
 * Configure base Kotlin with Android options
 */

internal fun Project.configureKotlinMultiplatform(
    kotlinMultiplatformExtension: KotlinMultiplatformExtension
) {
    kotlinMultiplatformExtension.apply {
        applyDefaultHierarchyTemplate()

        if (pluginManager.hasPlugin("com.android.library")) {
            androidTarget()
        }
        listOf(
            iosX64(),
            iosArm64(),
            iosSimulatorArm64(),
        ).forEach { target ->
            target.binaries.framework {
                baseName = path.substring(1).replace(':', '-')
            }
        }

        targets.withType<KotlinNativeTarget>().configureEach {
            binaries.all {
                // Add linker flag for SQLite. See:
                // https://github.com/touchlab/SQLiter/issues/77
                linkerOpts("-lsqlite3")
            }

            compilations.configureEach {
                compilerOptions.configure {
                    // Try out preview custom allocator in K/N 1.9
                    // https://kotlinlang.org/docs/whatsnew19.html#preview-of-custom-memory-allocator
                    freeCompilerArgs.add("-Xallocator=custom")

                    // https://kotlinlang.org/docs/whatsnew19.html#compiler-option-for-c-interop-implicit-integer-conversions
                    freeCompilerArgs.add("-XXLanguage:+ImplicitSignedToUnsignedIntegerConversion")

                    // Enable debug symbols:
                    // https://kotlinlang.org/docs/native-ios-symbolication.html
                    freeCompilerArgs.add("-Xadd-light-debug=enable")

                    // Various opt-ins
                    freeCompilerArgs.addAll(
                        "-opt-in=kotlinx.cinterop.ExperimentalForeignApi",
                        "-opt-in=kotlinx.cinterop.BetaInteropApi",
                    )
                }
            }
        }

        targets.configureEach {
            compilations.configureEach {
                compilerOptions.configure {
                    freeCompilerArgs.add("-Xexpect-actual-classes")
                }
            }
        }
    }
}
