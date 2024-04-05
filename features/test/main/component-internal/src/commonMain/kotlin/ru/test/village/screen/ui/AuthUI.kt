package ru.test.village.screen.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun AuthUI() {
    Scaffold(
        topBar = { AuthTopBar() },
        content = { paddingValues ->
            AuthContent(
                modifier = Modifier.padding(paddingValues)
            )
        }
    )
}