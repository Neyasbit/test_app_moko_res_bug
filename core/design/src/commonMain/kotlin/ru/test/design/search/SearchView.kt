package ru.test.design.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import ru.test.resources.Resources

@Composable
fun SearchView(
    searchTextState: MutableState<TextFieldValue>,
    modifier: Modifier = Modifier,
    textViewColors: TextFieldColors = DefaultSearchViewColors(),
    shape: Shape = RoundedCornerShape(4.dp),
    searchHintText: String = stringResource(Resources.strings.search_hint)
) {
    val focusRequester = remember { FocusRequester() }
    val windowInfo = LocalWindowInfo.current

    /*LaunchedEffect(windowInfo) {
        snapshotFlow { windowInfo.isWindowFocused }.collect { isWindowFocused ->
            if (isWindowFocused) {
                focusRequester.requestFocus()
            }
        }
    }*/

    OutlinedTextField(
        value = searchTextState.value,
        onValueChange = { value ->
            searchTextState.value = value
        },
        modifier = modifier
            .fillMaxWidth()
            .focusRequester(focusRequester),
        textStyle = MaterialTheme.typography.bodyMedium,
        leadingIcon = {
            Icon(
                painter = painterResource(Resources.images.ic_search),
                contentDescription = stringResource(Resources.strings.cd_search)
            )
        },
        placeholder = {
            Text(text = searchHintText.uppercase(), color = MaterialTheme.colorScheme.secondary)
        },
        singleLine = true,
        shape = shape,
        colors = textViewColors
    )
}