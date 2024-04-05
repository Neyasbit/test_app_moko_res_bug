package ru.test.design.topbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopAppBarColors(
    containerColor: Color = MaterialTheme.colorScheme.primary,
    scrolledContainerColor: Color = MaterialTheme.colorScheme.primary,
    navigationIconContentColor: Color = MaterialTheme.colorScheme.onPrimary,
    titleContentColor: Color = MaterialTheme.colorScheme.onPrimary,
    actionIconContentColor: Color = MaterialTheme.colorScheme.onPrimary
) = TopAppBarDefaults.topAppBarColors(
    containerColor = containerColor,
    scrolledContainerColor = scrolledContainerColor,
    navigationIconContentColor = navigationIconContentColor,
    titleContentColor = titleContentColor,
    actionIconContentColor = actionIconContentColor
)