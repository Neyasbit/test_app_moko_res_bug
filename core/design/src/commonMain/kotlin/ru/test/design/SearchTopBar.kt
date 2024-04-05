package ru.test.design

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import ru.test.design.buttons.IconButton
import ru.test.design.search.SearchView
import ru.test.resources.Resources

@Composable
fun SearchTopBar() {
    val searchTextState = remember { mutableStateOf(TextFieldValue(String())) }
    var searchVisibleState by remember { mutableStateOf(false) }
    TopAppBar(
        title = {
            Box {
                AnimateVisible(!searchVisibleState) {
                    Icon(
                        painter = painterResource(Resources.images.ic_logo),
                        contentDescription = null
                    )
                }
                AnimateVisible(searchVisibleState) {
                    SearchView(searchTextState)
                }
            }
        },
        backgroundColor = Color.White,
        actions = {
            Crossfade(targetState = searchVisibleState) { searchVisible ->
                when (searchVisible) {
                    true -> IconButton(
                        icon = Resources.images.ic_close,
                        contentDescription = stringResource(Resources.strings.cd_close)
                    ) {
                        searchTextState.value = TextFieldValue(String())
                        searchVisibleState = !searchVisibleState
                    }

                    false -> IconButton(
                        icon = Resources.images.ic_search,
                        contentDescription = stringResource(Resources.strings.cd_search)
                    ) {
                        searchVisibleState = !searchVisibleState
                    }
                }
            }
        }
    )
}

@Composable
internal fun AnimateVisible(visible: Boolean, content: @Composable () -> Unit) {
    val enterAnimate = fadeIn() + slideInVertically(initialOffsetY = { -it })
    val endAnimate = fadeOut() + slideOutVertically(targetOffsetY = { it })
    AnimatedVisibility(
        visible = visible,
        enter = enterAnimate,
        exit = endAnimate
    ) {
        content.invoke()
    }
}