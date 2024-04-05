import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.the
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

@Suppress("unused")
internal class FeatureInternalPlugin : Plugin<Project> {

    override fun apply(target: Project) = target.run {
        val libs = the<LibrariesForLibs>()

        pluginManager.run {
            apply<CodeQualityConventionPlugin>()
            apply<KoinAnnotationConventionPlugin>()
            apply(libs.plugins.compose.get().pluginId)
        }

        extensions.configure<KotlinMultiplatformExtension> {

            sourceSets.commonMain {
                dependencies {
                    implementation(libs.arkivanov.decompose)
                    implementation(libs.arkivanov.decompose.extensions.compose)
                    implementation(libs.arkivanov.essenty.lifecycle.coroutines)
                    implementation(libs.kotlinx.coroutines.core)

                    implementation(project( ":core:decompose"))
                    implementation(project( ":core:design"))
                    implementation(project( ":core:resources"))
                }
            }
        }
    }
}