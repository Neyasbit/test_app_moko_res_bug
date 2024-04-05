import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.internal.utils.KOTLIN_ANDROID_PLUGIN_ID
import helpers.AndroidVersions.TARGET_SDK
import helpers.NamesOfPlugin.ANDROID_APPLICATION
import helpers.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * see build.gradle.kts gradlePlugin block
 */
@Suppress("unused")
internal class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {

        with(pluginManager) {
            apply(ANDROID_APPLICATION)
            apply(KOTLIN_ANDROID_PLUGIN_ID)
        }

        extensions.configure<ApplicationExtension> {
            configureKotlinAndroid(this)
            defaultConfig.targetSdk = TARGET_SDK
        }
    }
}