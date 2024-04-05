import com.android.build.gradle.LibraryExtension
import helpers.AndroidVersions.TARGET_SDK
import helpers.NamesOfPlugin.ANDROID_LIBRARY
import helpers.configureAndroidMultiplatform
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * see build.gradle.kts gradlePlugin block
 */
@Suppress("unused")
internal class AndroidOnlyLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        with(pluginManager) {
            apply(ANDROID_LIBRARY)
        }

        extensions.configure<LibraryExtension> {
            configureAndroidMultiplatform(this)
            defaultConfig.targetSdk = TARGET_SDK
        }
    }
}