package ru.test.village.screen.integration

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam
import org.koin.core.component.KoinComponent
import ru.test.village.screen.MainScreenComponent
import ru.test.village.screen.ui.AuthUI

@Factory
internal class DefaultMainScreenComponent(
    @InjectedParam componentContext: ComponentContext
) : MainScreenComponent,
    ComponentContext by componentContext,
    KoinComponent {

    @Composable
    override fun Render(modifier: Modifier) {
        AuthUI()
    }
}