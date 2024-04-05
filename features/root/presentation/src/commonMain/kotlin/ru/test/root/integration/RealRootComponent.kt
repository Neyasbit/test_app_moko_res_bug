package ru.test.root.integration

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf
import ru.test.root.RootComponent
import ru.test.root.RootComponent.Child
import ru.test.startup.root.StartupRootComponent

@Factory
class RealRootComponent(
    @InjectedParam componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext, KoinComponent {

    private val navigation = StackNavigation<Config>()

    private val _stack = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.StartupRoot,
        handleBackButton = true
    ) { configuration, componentContext ->
        when (configuration) {
            is Config.StartupRoot -> Child.StartupRoot(
                get<StartupRootComponent> { parametersOf(componentContext) }
            )
        }
    }
    override val stack: Value<ChildStack<*, Child>> = _stack

    @Serializable
    private sealed class Config {
        @Serializable
        data object StartupRoot : Config()
    }
}