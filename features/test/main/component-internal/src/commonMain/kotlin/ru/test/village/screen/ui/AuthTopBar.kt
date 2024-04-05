package ru.test.village.screen.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import dev.icerock.moko.resources.compose.stringResource
import ru.test.design.topbar.DefaultTopAppBarColors
import ru.test.resources.Resources

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AuthTopBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(Resources.strings.auth_title).uppercase(),
                style = MaterialTheme.typography.titleMedium
            )
        },
        colors = DefaultTopAppBarColors()
    )
}