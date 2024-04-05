import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.utils.KOTLIN_ANDROID_PLUGIN_ID
import helpers.AndroidVersions.TARGET_SDK
import helpers.NamesOfPlugin.ANDROID_LIBRARY
import helpers.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * see build.gradle.kts gradlePlugin block
 */
@Suppress("unused")
internal class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        with(pluginManager) {
            apply(ANDROID_LIBRARY)
            apply(KOTLIN_ANDROID_PLUGIN_ID)
        }

        extensions.configure<LibraryExtension> {
            configureKotlinAndroid(this)
            defaultConfig.targetSdk = TARGET_SDK
        }
    }
}