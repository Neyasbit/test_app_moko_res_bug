import com.android.build.gradle.internal.utils.KOTLIN_MPP_PLUGIN_ID
import helpers.configureKotlinMultiplatform
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

/**
 * see build.gradle.kts gradlePlugin block
 */
@Suppress("unused")
internal class MultiplatformLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        with(pluginManager) {
            apply(KOTLIN_MPP_PLUGIN_ID)
        }

        extensions.configure<KotlinMultiplatformExtension> {
            configureKotlinMultiplatform(this)
        }
    }
}