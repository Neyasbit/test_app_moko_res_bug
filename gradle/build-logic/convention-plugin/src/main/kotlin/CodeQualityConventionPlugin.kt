import helpers.AppKtlintPlugin
import helpers.AppSpotlessPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

/**
 * see build.gradle.kts gradlePlugin block
 */
@Suppress("unused")
internal class CodeQualityConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        //Todo надо включать
        //apply<AppDetektPlugin>()
        apply<AppKtlintPlugin>()
        apply<AppSpotlessPlugin>()
    }
}