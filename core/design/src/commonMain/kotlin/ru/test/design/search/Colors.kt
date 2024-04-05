package ru.test.design.search

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable

@Composable
fun DefaultSearchViewColors() = OutlinedTextFieldDefaults.colors(
    focusedTextColor = MaterialTheme.colorScheme.onPrimary,
    unfocusedTextColor = MaterialTheme.colorScheme.outline,
    focusedContainerColor = MaterialTheme.colorScheme.background,
    unfocusedContainerColor = MaterialTheme.colorScheme.background,
    cursorColor = MaterialTheme.colorScheme.secondary,
    focusedBorderColor = MaterialTheme.colorScheme.outline,
    unfocusedBorderColor = MaterialTheme.colorScheme.outline,
    focusedLeadingIconColor = MaterialTheme.colorScheme.outline,
    unfocusedLeadingIconColor = MaterialTheme.colorScheme.outline
)