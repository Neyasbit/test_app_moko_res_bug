package ru.test.design

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import ru.test.resources.Resources

@Composable
fun NetworkError(
    onRetryClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Center)
                .offset(y = (-50).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(Resources.images.ic_no_network),
                contentDescription = "logo",
                alignment = Center,
                modifier = Modifier.size(300.dp)
            )
            Text(
                text = stringResource(Resources.strings.no_internet),
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = stringResource(Resources.strings.no_internet_connection),
                style = MaterialTheme.typography.titleSmall
            )
            TextButton(onClick = onRetryClick) {
                Text(
                    text = stringResource(Resources.strings.retry),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}