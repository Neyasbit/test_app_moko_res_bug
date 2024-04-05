package ru.test.design

import androidx.compose.runtime.Composable

@Composable
fun NoNetworkPlaceholder(
    onRetryClick: () -> Unit
) {
    NetworkError(onRetryClick)
}