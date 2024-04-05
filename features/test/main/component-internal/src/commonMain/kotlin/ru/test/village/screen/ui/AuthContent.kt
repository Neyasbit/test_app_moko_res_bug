package ru.test.village.screen.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.compose.fontFamilyResource
import dev.icerock.moko.resources.compose.stringResource
import ru.test.resources.Resources

@Composable
internal fun AuthContent(
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.primary)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                color = MaterialTheme.colorScheme.onBackground,
                fontFamily = fontFamilyResource(Resources.fonts.drukwidecyr_bold),
                style = MaterialTheme.typography.bodyLarge,
                text = stringResource(Resources.strings.auth_description).uppercase()
            )
            CodeView()
        }
    }
}

@Composable
private fun CodeView() {
    val density = LocalDensity.current

    Box(modifier = Modifier) {
        var contentSize by remember {
            mutableStateOf(DpSize.Zero)
        }
    }

    ReadyState { _, _ -> }
}

@Composable
private fun ReadyState(
    onEnterClick: (String, String) -> Unit
) {
    val emailTextState = remember { mutableStateOf(TextFieldValue()) }
    val codeTextState = remember { mutableStateOf(TextFieldValue()) }

    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            AuthTextField(
                message = emailTextState,
                placeHolderText = Resources.strings.auth_email_hint
            )
            AuthTextField(
                message = codeTextState,
                placeHolderText = Resources.strings.auth_enter_code_hint
            )
        }
        AuthButton(
            text = Resources.strings.auth_enter_button_title,
            onClick = {
                onEnterClick(
                    emailTextState.value.text,
                    codeTextState.value.text
                )
            }
        )
    }
}

@Composable
private fun ErrorState(
    modifier: Modifier,
    onReEnterClick: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Box(
            modifier = modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.bodyLarge,
                text = stringResource(Resources.strings.auth_error),
                textAlign = TextAlign.Center
            )
        }
        AuthButton(
            text = Resources.strings.auth_re_enter_button_title,
            onClick = onReEnterClick
        )
    }
}

@Composable
private fun LoadingState(modifier: Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(color = MaterialTheme.colorScheme.primaryContainer)
    }
}

@Composable
private fun AuthTextField(
    message: MutableState<TextFieldValue>,
    placeHolderText: StringResource
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 36.dp),
        value = message.value,
        onValueChange = { message.value = it },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
                keyboardController?.hide()
            }
        ),
        placeholder = {
            Text(
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.bodyMedium,
                text = stringResource(placeHolderText).uppercase()
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
            focusedBorderColor = MaterialTheme.colorScheme.secondary
        ),
        shape = RectangleShape
    )
}

@Composable
private fun AuthButton(
    text: StringResource,
    onClick: () -> Unit
) {
    val focusManager = LocalFocusManager.current

    OutlinedButton(
        modifier = Modifier
            .height(52.dp)
            .fillMaxWidth(),
        onClick = {
            focusManager.clearFocus()
            onClick()
        },
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = stringResource(text).uppercase(),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}