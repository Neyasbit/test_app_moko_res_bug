package ru.test.event

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.logging.store.LoggingStoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Single
import ru.test.root.RootModule
import ru.test.startup.StartupRootModule
import ru.test.village.screen.TestModule

@org.koin.core.annotation.Module(
    includes = [
        StartupRootModule::class,
        RootModule::class,
        TestModule::class
    ]
)
@ComponentScan
class SharedModule {
    @Single
    fun provideStoreFactory(): StoreFactory = LoggingStoreFactory(DefaultStoreFactory())
}