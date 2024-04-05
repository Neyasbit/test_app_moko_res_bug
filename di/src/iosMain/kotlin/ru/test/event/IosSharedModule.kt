package ru.test.event

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import platform.Foundation.NSBundle
import platform.Foundation.NSUserDefaults
import ru.test.event.base.app.ApplicationInfo
import ru.test.event.base.app.Flavor

@Module
@ComponentScan
class IosSharedModule {

    @Factory
    fun provideFlavor() = Flavor.Qa

    @Single
    fun provideNSUser(): NSUserDefaults = NSUserDefaults.standardUserDefaults

    @Single
    fun provideApplicationInfo(flavor: Flavor) = ApplicationInfo(
        packageName = NSBundle.mainBundle.bundleIdentifier ?: error("Bundle ID not found"),
        debugBuild = Platform.isDebugBinary,
        flavor = flavor,
        versionName = NSBundle.mainBundle.infoDictionary?.get("CFBundleShortVersionString") as? String ?: "",
        versionCode = (NSBundle.mainBundle.infoDictionary?.get("CFBundleVersion") as? String)?.toIntOrNull() ?: 0
    )
}