import com.android.build.gradle.internal.utils.KSP_PLUGIN_ID
import helpers.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

@Suppress("unused")
internal class KoinAnnotationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {

        pluginManager.apply(KSP_PLUGIN_ID)

        extensions.configure<KotlinMultiplatformExtension> {
            sourceSets.commonMain {
                //kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")
                dependencies {

                    implementation(libs.findLibrary("koin-core").get())
                    implementation(libs.findLibrary("koin-annotations").get())
                }
            }
        }

        dependencies {
            with(libs.findLibrary("koin-kspCompiler").get()) {
                add("kspCommonMainMetadata", this)
                add("kspAndroid", this)
                add("kspIosX64", this)
                add("kspIosArm64", this)
                add("kspIosSimulatorArm64", this)
                add("kspIosSimulatorArm64Test", this)
            }
        }
    }
}