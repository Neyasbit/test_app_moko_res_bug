package ru.test.design.buttons

import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import dev.icerock.moko.resources.compose.stringResource
import ru.test.resources.Resources

@Composable
fun MenuBackButton(
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick
    ) {
        Text(
            text = stringResource(Resources.strings.go_to_the_menu).uppercase(),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}