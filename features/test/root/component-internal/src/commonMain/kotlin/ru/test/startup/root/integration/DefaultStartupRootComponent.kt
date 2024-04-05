package ru.test.startup.root.integration

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pushNew
import kotlinx.serialization.Serializable
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.parameterSetOf
import ru.test.core.decompose.ComposeComponent
import ru.test.startup.root.StartupRootComponent
import ru.test.village.screen.MainScreenComponent

@Factory
internal class DefaultStartupRootComponent(
    @InjectedParam componentContext: ComponentContext
) : StartupRootComponent,
    ComponentContext by componentContext,
    KoinComponent {

    private val navigation = StackNavigation<MenuConfiguration>()

    @OptIn(ExperimentalDecomposeApi::class)
    private val menuItemCallback: (MenuConfiguration) -> Unit = {
        navigation.pushNew(it)
    }

    private val _stack =
        childStack(
            source = navigation,
            serializer = MenuConfiguration.serializer(),
            initialConfiguration = MenuConfiguration.Main,
            handleBackButton = true,
            childFactory = ::createChild
        )

    private fun createChild(
        configuration: MenuConfiguration,
        componentContext: ComponentContext
    ): ComposeComponent = when (configuration) {
        is MenuConfiguration.Main -> get<MainScreenComponent> {
            parameterSetOf(
                componentContext,
                menuItemCallback
            )
        }
    }

    @Composable
    override fun Render(modifier: Modifier) {
        Children(
            stack = _stack,
            animation = stackAnimation(slide())
        ) { child ->
            child.instance.Render(Modifier)
        }
    }
}

@Serializable
sealed interface MenuConfiguration {
    @Serializable
    data object Main : MenuConfiguration
}