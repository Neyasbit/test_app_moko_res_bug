package ru.test.root.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import dev.icerock.moko.resources.compose.painterResource
import ru.test.design.theme.MyApplicationTheme
import ru.test.resources.Resources
import ru.test.root.RootComponent

@Composable
fun RootScreen(component: RootComponent) {
    val snackbarHostState = remember { SnackbarHostState() }

    MyApplicationTheme {
        Surface {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize(),
                snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(Resources.images.background_menu),
                    contentDescription = "background menu"
                )
                Children(
                    stack = component.stack,
                    animation = stackAnimation(fade())
                ) {
                    when (val child = it.instance) {
                        is RootComponent.Child.StartupRoot -> child.component.Render(Modifier.fillMaxSize())
                    }
                }
            }
        }
    }
}